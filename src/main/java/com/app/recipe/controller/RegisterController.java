package com.app.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.recipe.model.RegisterDto;

@Controller
public class RegisterController {
	@PostMapping("/member/regist.do")
	public String regist(@RequestBody RegisterDto dto) {
		System.out.println("dto: " + dto);
		//db연동필요: insert
		//메일 보내기
		return "/signup_check.jsp"; //ajax를 쓰지 말까?
	}
}