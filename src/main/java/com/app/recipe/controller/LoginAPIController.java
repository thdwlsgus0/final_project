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
    	OAuth2AccessToken oauthToken;
    	oauthToken = naverLoginBO.getAccessToken(session, code, state);
    	
    	apiResult = naverLoginBO.getUserProfile(oauthToken); //String �삎�떇�쓽 json �뜲�씠�꽣
    	
    	JSONParser parser = new JSONParser();
    	Object obj = parser.parse(apiResult);
    	JSONObject jsonObj = (JSONObject) obj;
    	

    	JSONObject response_obj = (JSONObject)jsonObj.get("response");
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
    	System.out.println("濡쒓렇�븘�썐 logout");
        session.invalidate();
        
        return "/login.jsp";
    }
    

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
		
		HashMap<String, Object> ret = new HashMap<String, Object>();
		if (svc.idcheck(name, auth_str)) {

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
				ret.put("login", false);
			}
		}
		session.setAttribute("auth", auth_str);
		return ret;
	}
}
