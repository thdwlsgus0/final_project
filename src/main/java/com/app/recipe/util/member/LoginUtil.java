package com.app.recipe.util.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.RegisterService;

public class LoginUtil {
	public static String logincheck(RegisterService svc, String name, String email, String profile, String auth_str, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (svc.idcheck(email, auth_str)) {
			session.setAttribute("regi_email", email);
			session.setAttribute("regi_name", name);
			session.setAttribute("regi_profile", profile);
			session.setAttribute("auth", auth_str);
			return "/member/signup";
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
		String name;
		RegisterDto dto;
		String[] split = id.split("!");
		if(split.length == 4 && split[0].trim().equals("auth")) {
			String auth = split[1];
			String email = split[2];
			dto = svc.select(email, auth);
			name = split[3];
		}
		else {
			dto = svc.select(id);
			name = dto.getId();
		}
		if (dto != null) {
			if (dto.getCheck().equals("T")) {
				session.setAttribute("email", dto.getEmail());
				session.setAttribute("sessionId", name);
				session.setAttribute("realId", dto.getId());
				session.setAttribute("profile", dto.getProfile());
				return "/";
			}
			else return "/login/email";
		}
		return "/access";
	}
}
