package com.app.recipe.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.recipe.dao.RegisterService;
import com.app.recipe.model.RegisterDto;


@Controller
public class RegisterController {
	@Inject
	private RegisterService svc;
	
	@PostMapping("/member/regist.do")
	public String regist(@RequestBody RegisterDto dto) {
		svc.register(dto);
		//메일 보내기
		return "/member/signup_check.jsp";
	}
	
	@PostMapping("/member/idcheck.do")
	public String idcheck(@RequestBody String id, Model model) {
		if(svc.idcheck(id)) model.addAttribute("idcheck", true);
		else model.addAttribute("idcheck", false);
		return "/member/signup_idcheck.jsp";
	}
}