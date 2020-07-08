package com.app.recipe.model;

import java.util.List;

public class MemberVO {
	private String id;
	private String pw;
	private List<AuthVO> authlist;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public List<AuthVO> getAuthlist() {
		return authlist;
	}
	public void setAuthlist(List<AuthVO> authlist) {
		this.authlist = authlist;
	}
}
