package com.app.recipe.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.recipe.dao.RegisterService;

@Controller
public class GoogleOAuthController {

	@Inject
	private RegisterService svc;
	
	@PostMapping("/login/google.do")
	public String login(HttpServletRequest request) throws FileNotFoundException, IOException {
		
		
		return "/member/login_google.jsp";
	}

	//이하 생략
	@GetMapping("/login/google_ok.do")
	public String login2(String code) {
		if (code == null || code.isEmpty())
			return "redirect:/loginForm.do";		

		// 사용자 정보 가져와서 가입시키고...

		return "redirect:/member/index.do";
	}
}
