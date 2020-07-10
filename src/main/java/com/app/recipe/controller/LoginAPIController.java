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
	
	@Inject
	private RegisterService svc;
	
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
	
    @RequestMapping(value="/callback.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpServletRequest req) throws IOException, ParseException{
    	HttpSession session = req.getSession();
    	OAuth2AccessToken oauthToken;
    	oauthToken = naverLoginBO.getAccessToken(session, code, state);
    	
    	apiResult = naverLoginBO.getUserProfile(oauthToken);
    	
    	JSONParser parser = new JSONParser();
    	Object obj = parser.parse(apiResult);
    	JSONObject jsonObj = (JSONObject) obj;

    	JSONObject response_obj = (JSONObject)jsonObj.get("response");
    	String nickname = (String)response_obj.get("nickname");
    	String email = response_obj.get("email").toString();
    	String profile = response_obj.get("profile_image").toString();
    	model.addAttribute("result", apiResult);
    	
    	return LoginUtil.logincheck(svc, nickname, email, profile, "naver", req);
    }
    
    @RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session)throws IOException{
        session.invalidate();
        return "redirect:/login";
    }
}
