package com.app.recipe.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.recipe.model.MemberVO;
import com.app.recipe.service.RegisterService;

public class CustomDetailService implements UserDetailsService {
	private RegisterService svc;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = svc.securitylogin(username);
		return vo == null ? null : new UserDetail(vo);
	}
	
	@Inject
	public void setSvc(RegisterService svc) {
		this.svc = svc;
	}
}