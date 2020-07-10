package com.app.recipe.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.recipe.model.MemberVO;
import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.RegisterService;

public class CustomDetailService implements UserDetailsService {
	private RegisterService svc;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo;
		boolean authlogin = false;
		String[] split = username.split("!");
		if(split.length == 4 && split[0].trim().equals("auth")) {
			String auth = split[1];
			String email = split[2];
			RegisterDto dto = svc.select(email, auth);
			vo = svc.securitylogin(dto.getId());
			authlogin = true;
		}
		else vo = svc.securitylogin(username);
		return vo == null ? null : new CustomUserDetails(vo, authlogin);
	}
	
	@Inject
	public void setSvc(RegisterService svc) {
		this.svc = svc;
	}
}