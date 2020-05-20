package com.app.recipe.model;

public class memberDTO {
	private String id; // 아이디
	private String password; // 비밀번호
	private String email; // 이메일
	private String date; // 가입일자

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "memberDTO [id=" + id + ", password=" + password + ", email=" + email + ", date=" + date + "]";
	}

}
