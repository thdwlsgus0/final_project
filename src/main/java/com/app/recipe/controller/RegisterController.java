package com.app.recipe.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "/member/signup_check.jsp";
	}
	
	@PostMapping("/member/idcheck.do")
	public String idcheck(@RequestBody String id, Model model) {
		if(svc.idcheck(id)) model.addAttribute("idcheck", true);
		else model.addAttribute("idcheck", false);
		return "/member/signup_idcheck.jsp";
	}
	
	@GetMapping("/member/emailcheck.do")
	public String mailcheck(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String dice = req.getParameter("dice");
		try {
			if(svc.dicecheck(id, dice)) {
				RegisterDto dto = svc.select(id);
				dto.setCheck("T");
				svc.update(dto);
				model.addAttribute("check", true);
			}
		else model.addAttribute("check", false);
		} catch(Exception e) { System.out.println(String.format(
				"잘못된 접근 들어옴 >> id[%s], dice[%s] >> %s", id, dice, e.getMessage())); }
		return "/member/signup_dice.jsp";
	}
}