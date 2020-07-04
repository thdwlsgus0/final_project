package com.app.recipe.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberModVo {
	private String id, pw, favor, phone;
	/** 프로필 원본, 꺼낸 이후 수정된 프로필 저장 */
	private String orifile;
	private MultipartFile file;
	
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
	public String getFavor() {
		return favor;
	}
	public void setFavor(String favor) {
		this.favor = favor;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrifile() {
		return orifile;
	}
	public void setOrifile(String orifile) {
		this.orifile = orifile;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
