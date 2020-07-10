package com.app.recipe.model;

import java.sql.Date;

public class RegisterDto {
	private String id;
	private String pw;
	private Date date;
	private String favor;
	private String birth;
	private String gender;
	private String email;
	private String phone;
	private String check;
	private String profile;
	private String auth;
	
	public RegisterDto() {}
	public RegisterDto(String email) {
		this.email = email;
	}
	public RegisterDto(String id, boolean nv) {
		this.id = id;
	}
	public RegisterDto(String email, String auth) {
		this.email = email;
		this.auth = auth;
	}
	public RegisterDto(String id, String pw, boolean nv) {
		this.id = id;
		this.pw = pw;
	}
	public RegisterDto(String email, String auth, String pw) {
		this.email = email;
		this.auth = auth;
		this.pw = pw;
	}
	public RegisterDto(MemberModVo vo) {
		pw = vo.getPw();
		favor = vo.getFavor();
		phone = vo.getPhone();
		profile = vo.getOrifile();
	}
	
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFavor() {
		return favor;
	}
	public void setFavor(String favor) {
		this.favor = favor;
	}
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return String.format("id[%s] pw[%s] favor[%s] birth[%s] "
				+ "gender[%s] email[%s] phone[%s] check[%s] profile[%s] auth[%s]", 
				id, pw, favor, birth, gender, email, phone, check, profile, auth);
	}
}

