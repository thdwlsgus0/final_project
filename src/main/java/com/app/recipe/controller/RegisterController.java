
package com.app.recipe.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
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
		System.out.println("dto: " + dto);
		svc.register(dto);
		//���� ������
		return "/member/signup_check.jsp"; //ajax�� ���� ����?
	}
}