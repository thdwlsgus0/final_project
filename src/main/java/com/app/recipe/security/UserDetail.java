package com.app.recipe.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.app.recipe.model.MemberVO;

public class UserDetail extends User {
	private static final long serialVersionUID = 1;
	private MemberVO member;

	public UserDetail(MemberVO vo) {
		super(vo.getId(), vo.getPw(), vo.getAuthlist().stream().
				map(auth -> new SimpleGrantedAuthority(auth.getAuth())).
				collect(Collectors.toList()));
		this.member = vo;
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
}
