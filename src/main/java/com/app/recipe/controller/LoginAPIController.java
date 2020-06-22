package com.app.recipe.controller;
 
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.personal.kakaoLogin.service.KakaoAPI;
import com.personal.naverLogin.service.NaverLoginBO;

/*
 loginAPI 호출
 */
@Controller
public class LoginAPIController {
	
	@Autowired
	private KakaoAPI kakao;
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
    @RequestMapping(value="/login.do",produces="application/json",method=RequestMethod.GET)
    public String login(@RequestParam("code") String code,RedirectAttributes ra,HttpSession session,HttpServletResponse response)throws IOException {
        
    	String access_Token = kakao.getAccessToken(code);
    	HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        //System.out.println("code : " + code);
        //System.out.println("controller access_token : " + access_Token);
        if (userInfo.get("email") != null) {
            //session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
    	
        return "login";
    }
    @RequestMapping(value="/naverLogin.do", produces="application/json", method={RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, HttpSession session) {
    	/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
    	String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
    	System.out.println("네이버:"+naverAuthUrl);
    	model.addAttribute("url", naverAuthUrl);
    	return "login/naverlogin.jsp";
    }
    // 네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value="/callback.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException{
    	System.out.println("여기는 callback");
    	OAuth2AccessToken oauthToken;
    	oauthToken = naverLoginBO.getAccessToken(session, code, state);
    	
    	// 1. 로그인 사용자 정보를 읽어온다.
    	apiResult = naverLoginBO.getUserProfile(oauthToken); //String 형식의 json 데이터
    	
    	// 2. String 형식인 apiResult를 json형태로 바꿈
    	JSONParser parser = new JSONParser();
    	Object obj = parser.parse(apiResult);
    	JSONObject jsonObj = (JSONObject) obj;
    	
    	// 3. 데이터 파싱
    	// Top레벨 단계 _response 파싱
    	JSONObject response_obj = (JSONObject)jsonObj.get("response");
    	// response의 nickname값 파싱
    	String nickname = (String)response_obj.get("nickname");
    	
    	System.out.println(nickname);
    	
    	//4. 파싱 닉네임 세션으로 저장
    	session.setAttribute("sessionId", nickname);//세션 설정
    	
    	model.addAttribute("result", apiResult);
    	
    	return "login";	
    }
    @RequestMapping(value="/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session)throws IOException{
    	System.out.println("여기는 logout");
        session.invalidate();
        
        return "redirect:index.jsp";
    	
    }
}
