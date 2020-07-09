package com.app.recipe.controller;
 
import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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

import com.app.recipe.service.RegisterService;
import com.app.recipe.util.member.LoginUtil;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.personal.naverLogin.service.NaverLoginBO;

@Controller
public class LoginAPIController {
	
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO= naverLoginBO;
	}
	
	@GetMapping("/login")
	public String login_page(String error, String logout, Model model, HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		model.addAttribute("url", naverAuthUrl);
		if(error != null) model.addAttribute("error", "아이디 혹은 패스워드를 확인해주세요.");
		if(logout != null) model.addAttribute("logout", "로그아웃되었습니다.");
		return "/member/login";
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
    	
    	return LoginUtil.logincheck(svc, nickname, email, profile, "naver", session);
    }
    @RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session)throws IOException{
        session.invalidate();        
        return "redirect:/login/member";
    }
    

	@Inject
	private RegisterService svc;
	
	@PostMapping("/login/google")
	public @ResponseBody HashMap<String, Object> login(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = map.get("email").toString();
		String name = map.get("name").toString();
		String profile = map.get("imageUrl").toString();
		
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("url", LoginUtil.logincheck(svc, name, email, profile, "google", session));
		return hash;
	}
}
