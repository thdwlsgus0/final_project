package com.app.recipe.util.login;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.RegisterService;

public class LoginUtil {
	public static String logincheck(RegisterService svc, String name, String email, String profile, String auth_str,
			HttpSession session) {
		HashMap<String, Object> ret = new HashMap<String, Object>();
		if (svc.idcheck(email, auth_str)) {
			session.setAttribute("regi_email", email);
			session.setAttribute("regi_name", name);
			session.setAttribute("regi_profile", profile);
			ret.put("regi", true);
		} else {
			RegisterDto dto = svc.select(email, auth_str);
			if (dto.getCheck().equals("T")) {
				// - 가입&인증된 상태라면 메인으로
				session.setAttribute("email", email);
				session.setAttribute("sessionId", name);
				session.setAttribute("realId", dto.getId());
				session.setAttribute("profile", profile);
				return "redirect:/member/signup.do";
			} else {
				return "redirect:/";
			}
		}
		session.setAttribute("auth", auth_str);
		return "redirect:/login/email";
	}
	
	public static String logincheck(RegisterService svc, String id, HttpSession session) {
		RegisterDto dto = svc.select(id);
		if (dto != null) {
			if (dto.getCheck().equals("T")) {
				session.setAttribute("email", dto.getEmail());
				session.setAttribute("sessionId", dto.getId());
				session.setAttribute("realId", dto.getId());
				session.setAttribute("profile", dto.getProfile());
				return "/";
			}
			else return "/login/email";
		}
		return "/access";
	}
}
