package com.app.recipe.util.member;

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
			session.setAttribute("auth", auth_str);
			return "/member/signup.do";
		} else {
			RegisterDto dto = svc.select(email, auth_str);
			if (dto.getCheck().equals("T")) {
				session.setAttribute("email", email);
				session.setAttribute("sessionId", name);
				session.setAttribute("realId", dto.getId());
				session.setAttribute("profile", profile);
				return "/";
			} else {
				return "/login/email";
			}
		}
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
