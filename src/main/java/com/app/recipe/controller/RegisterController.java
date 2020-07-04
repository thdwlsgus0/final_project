package com.app.recipe.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.RegisterService;

@Controller
public class RegisterController {
	@Inject
	private static RegisterService svc;


	@ResponseBody
	@PostMapping("/member/regist.do")
	public HashMap<String, Object> regist(@RequestBody RegisterDto dto) {
		svc.register(dto);
		return new HashMap<String, Object>();
	}

	@PostMapping("/member/idcheck.do")
	public String idcheck(@RequestBody String id, Model model) {
		if (svc.idcheck(id))
			model.addAttribute("idcheck", true);
		else
			model.addAttribute("idcheck", false);
		return "/member/signup_idcheck.jsp";
	}

	@PostMapping("/member/login.do")
	public String login(@RequestBody RegisterDto dto, HttpSession session) {
		RegisterDto dto2 = svc.login(dto.getId(), dto.getPw());
		if(dto2 == null) return "/member/null";
		
		session.setAttribute("email", dto2.getEmail());
		session.setAttribute("sessionId", dto2.getId());
		session.setAttribute("realId", dto2.getId());
		session.setAttribute("profile", dto2.getProfile());
		return "/member/signup_idcheck.jsp";
	}

	@GetMapping("/member/emailcheck.do")
	public String mailcheck(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String dice = req.getParameter("dice");
		System.out.println(String.format("id: %s, pw: %s", id, dice));
		try {
			if (svc.dicecheck(id, dice)) {
				RegisterDto dto = svc.select(id);
				dto.setCheck("T");
				svc.update(dto);
				model.addAttribute("check", true);
			} else
				model.addAttribute("check", false);
		} catch (Exception e) {
			System.out.println(String.format("잘못된 접근 들어옴 >> id[%s], dice[%s] >> %s", id, dice, e.getMessage()));
		}
		return "/member/signup_dice.jsp";
	}

	
}