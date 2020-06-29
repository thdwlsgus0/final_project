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
 loginAPI 호占쏙옙
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
		System.out.println("占쏙옙占싱뱄옙:"+naverAuthUrl);
		model.addAttribute("url", naverAuthUrl);
		return "/login.jsp";
	}
	
    @RequestMapping(value="/login.do",produces="application/json",method=RequestMethod.GET)
    public String login(@RequestParam("code") String code,RedirectAttributes ra,HttpSession session,HttpServletResponse response)throws IOException {
        
    	String access_Token = kakao.getAccessToken(code);
    	HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        //System.out.println("code : " + code);
        //System.out.println("controller access_token : " + access_Token);
        if (userInfo.get("email") != null) {
            //session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("sessionId", access_Token);
        }
    	
        return "/member/index.jsp";
    }
    // 占쏙옙占싱뱄옙 占싸깍옙占쏙옙 占쏙옙占쏙옙占쏙옙 callback호占쏙옙 占쌨소듸옙
    @RequestMapping(value="/callback.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException{
    	System.out.println("callback �샇異�");
    	OAuth2AccessToken oauthToken;
    	oauthToken = naverLoginBO.getAccessToken(session, code, state);
    	
    	// 1. 占싸깍옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占싻억옙쨈占�.
    	apiResult = naverLoginBO.getUserProfile(oauthToken); //String 占쏙옙占쏙옙占쏙옙 json 占쏙옙占쏙옙占쏙옙
    	
    	// 2. String 占쏙옙占쏙옙占쏙옙 apiResult占쏙옙 json占쏙옙占승뤄옙 占쌕뀐옙
    	JSONParser parser = new JSONParser();
    	Object obj = parser.parse(apiResult);
    	JSONObject jsonObj = (JSONObject) obj;
    	
    	// 3. 占쏙옙占쏙옙占쏙옙 占식쏙옙
    	// Top占쏙옙占쏙옙 占쌤곤옙 _response 占식쏙옙
    	JSONObject response_obj = (JSONObject)jsonObj.get("response");
    	// response占쏙옙 nickname占쏙옙 占식쏙옙
    	String nickname = (String)response_obj.get("nickname");
    	
    	System.out.println("�땳�꽕�엫:"+nickname);
    	System.out.println("apiResult:"+apiResult);
    	//4. 占식쏙옙 占싻놂옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
    	session.setAttribute("sessionId", nickname);//占쏙옙占쏙옙 占쏙옙占쏙옙
    	
    	model.addAttribute("result", apiResult);
    	System.out.println("/member/index.jsp");
    	return "/member/index.jsp";	
    }
    @RequestMapping(value="/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session)throws IOException{
    	System.out.println("濡쒓렇�븘�썐 logout");
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
		// 로그인 체크
		HashMap<String, Object> ret = new HashMap<String, Object>();
		if (svc.idcheck(name, "google")) {
			// - 가입하지 않았다면 가입창으로
			session.setAttribute("regi_email", email);
			session.setAttribute("regi_name", name + "   ");
			session.setAttribute("regi_profile", profile);
			ret.put("regi", true);
		} else {
			if(svc.select(name).getAuth().equals("T")) {
				// - 가입&인증된 상태라면 메인으로
				System.out.println("가입한 상태임");
				session.setAttribute("email", email);
				session.setAttribute("name", name);
				session.setAttribute("profile", profile);
				ret.put("login", true);	
			}
			else {
				// - 인증되지 않았음
				ret.put("login", false);
			}
		}
		session.setAttribute("auth", "google");
		return ret;
	}
}
