package com.app.recipe.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.app.recipe.service.RegisterService;
import com.app.recipe.util.member.LoginUtil;

public class LoginSuccess implements AuthenticationSuccessHandler {

	// private static final String ADMIN = "ROLE_ADMIN";
	// private static final String MEMBER = "ROLE_MEMBER";

	@Inject RegisterService svc;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("login success");

		String id = request.getParameter("mem_id");
		response.sendRedirect(LoginUtil.logincheck(svc, id, request.getSession()));
	}

}
