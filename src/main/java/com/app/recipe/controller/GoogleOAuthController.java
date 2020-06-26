package com.app.recipe.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.recipe.dao.RegisterService;

@Controller
public class GoogleOAuthController {

	@Inject
	private RegisterService svc;
	
	@PostMapping("/login/google.do")
	public @ResponseBody HashMap<String, Object> login(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = map.get("email").toString();
		String name = map.get("name").toString();
		String profile = map.get("imageUrl").toString();
		// 로그인 체크
		HashMap<String, Object> ret = new HashMap<String, Object>();
		if (svc.idcheck(email, "google")) {
			// - 가입하지 않았다면 가입창으로
			session.setAttribute("regi_email", email);
			session.setAttribute("regi_name", name + "   ");
			session.setAttribute("regi_profile", profile);
			ret.put("login", false);
		} else {
			// - 가입한 상태라면 메인으로
			session.setAttribute("email", email);
			session.setAttribute("name", name);
			session.setAttribute("profile", profile);
			ret.put("login", true);
		}
		session.setAttribute("auth", "google");
		return ret;
	}
}
