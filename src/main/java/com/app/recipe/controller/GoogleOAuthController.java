package com.app.recipe.controller;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.recipe.dao.RegisterService;
import com.app.recipe.model.RegisterDto;

@Controller
public class GoogleOAuthController {

	@Inject private RegisterService svc;
	@Inject GoogleConnectionFactory googleConnectionFactory;
	@Inject OAuth2Parameters googleOAuth2Paramters;
	private final String req = "https://www.googleapis.com/plus/v1/people/me?access_token=";
	
	@GetMapping("/login/google.do")
	public String login(Model model) {
		OAuth2Operations op = googleConnectionFactory.getOAuthOperations(); // 코드 발행
		String url = op.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Paramters);
		model.addAttribute("url", url);
		return "/member/login_google.jsp";
	}
	@GetMapping("/login/google_ok.do")
	public String login2(String code) {
		
		// 사용자 정보 가져와서 가입시키고...
				
		return "redirect:/member/index.do";
	}
}
