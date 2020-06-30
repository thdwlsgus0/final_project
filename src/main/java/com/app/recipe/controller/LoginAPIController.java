package com.app.recipe.controller;
 
import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.recipe.dao.RegisterService;
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
	
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO= naverLoginBO;
	}
	
	@RequestMapping(value ="/loginForm.do", method=RequestMethod.GET)
	public String login_page(Model model, HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		model.addAttribute("url", naverAuthUrl);
		return "/login.jsp";
	}
	
    @RequestMapping(value="/login.do",produces="application/json",method=RequestMethod.GET)
    public String login(@RequestParam("code") String code,RedirectAttributes ra,HttpSession session,HttpServletResponse response)throws IOException {
    	/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
    	String access_Token = kakao.getAccessToken(code);
    	HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        if (userInfo.get("email") != null) {
            session.setAttribute("sessionId", access_Token);
        }
    	
        return "/member/index.jsp";
    }
    
    // 네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value="/callback.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException{
    	System.out.println("callback 호출");
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
    	String email = response_obj.get("email").toString();
    	String profile = response_obj.get("profile_image").toString();
    	model.addAttribute("result", apiResult);
    	
    	HashMap<String, Object> hash = logincheck(nickname, email, profile, "naver", session);
    	if(hash.containsKey("regi")) if((boolean) hash.get("regi")) return "/member/signup.do";
    	if((boolean) hash.get("login")) return "/member/index.do";
    	return "/member/emailcheck.jsp";
    }
    @RequestMapping(value="/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session)throws IOException{
    	System.out.println("로그아웃 logout");
        session.invalidate();
        
        return "/login.jsp";
    }
    
    // 이하 구글
	@Inject
	private RegisterService svc;
	
	@PostMapping("/login/google.do")
	public @ResponseBody HashMap<String, Object> login(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = map.get("email").toString();
		String name = map.get("name").toString();
		String profile = map.get("imageUrl").toString();
		
		return logincheck(name, email, profile, "google", session);
	}
	
	public HashMap<String, Object> logincheck(String name, String email, String profile, String auth_str, HttpSession session){
		// 로그인 체크
		HashMap<String, Object> ret = new HashMap<String, Object>();
		if (svc.idcheck(name, auth_str)) {
			// - 가입하지 않았다면 가입창으로
			session.setAttribute("regi_email", email);
			session.setAttribute("regi_name", name);
			session.setAttribute("regi_profile", profile);
			ret.put("regi", true);
		} else {
			if(svc.select(name).getCheck().equals("T")) {
				// - 가입&인증된 상태라면 메인으로
				session.setAttribute("email", email);
				session.setAttribute("sessionId", name);
				session.setAttribute("profile", profile);
				ret.put("login", true);	
			}
			else {
				// - 인증되지 않았음
				ret.put("login", false);
			}
		}
		session.setAttribute("auth", auth_str);
		return ret;
	}
}
