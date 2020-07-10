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
	
	@Inject private RegisterService svc;
	
	@ResponseBody
	@PostMapping("/member/regist")
	public HashMap<String, Object> regist(@RequestBody RegisterDto dto) {
		svc.register(dto);
		return new HashMap<String, Object>();
	}
	
	@PostMapping("/member/idcheck")
	public String idcheck(@RequestBody String id, Model model) {
		if (svc.idcheck(id)) model.addAttribute("idcheck", true);
		else model.addAttribute("idcheck", false);
		return "/member/signup_idcheck";
	}

	@PostMapping("/login/member")
	public String login(@RequestBody RegisterDto dto, HttpSession session) {
		RegisterDto dto2;
		if(dto.getAuth() != null || dto.getAuth().length() > 0) {
			dto2 = svc.select(dto.getEmail(), dto.getAuth());
		}
		else dto2 = svc.login(dto.getId(), dto.getPw());
		if(dto2 == null) return "/member/null";
		
		session.setAttribute("email", dto2.getEmail());
		session.setAttribute("sessionId", dto2.getId());
		session.setAttribute("realId", dto2.getId());
		session.setAttribute("profile", dto2.getProfile());
		return "/member/signup_idcheck";
	}
	
	@GetMapping("/login/email")
	public String emailcheckyet() {
		return "/member/emailcheck";
	}

	@GetMapping("/member/emailcheck")
	public String mailcheck(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String auth = req.getParameter("auth");
		String dice = req.getParameter("dice");
		if(auth != null && auth.length() > 0) {
			try {
				RegisterDto dto = svc.select(email, auth);
				check(dice, dto, model);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			RegisterDto dto = svc.select(id);
			check(dice, dto, model);
		}
		return "/member/signup_dice";
	}

	private void check(String dice, RegisterDto dto, Model model) {
		if (dto.getCheck().equals(dice)) {
			dto.setCheck("T");
			svc.update(dto);
			model.addAttribute("check", true);
		} else model.addAttribute("check", false);
	}
}