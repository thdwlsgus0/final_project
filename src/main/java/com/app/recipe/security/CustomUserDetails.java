package com.app.recipe.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.app.recipe.model.MemberVO;

public class CustomUserDetails extends User {
	private static final long serialVersionUID = 1;
	private MemberVO member;
	private boolean authlogin;

	public CustomUserDetails(MemberVO vo, boolean authlogin) {
		super(vo.getId(), vo.getPw(), vo.getAuthlist().stream().
				map(au -> new SimpleGrantedAuthority(au.getAuth())).
				collect(Collectors.toList()));
		this.authlogin = authlogin;
	}

	public MemberVO getMember() {
		return member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public boolean isAuthlogin() {
		return authlogin;
	}

	public void setAuthlogin(boolean authlogin) {
		this.authlogin = authlogin;
	}
}
