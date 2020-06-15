<<<<<<< HEAD
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
		// TODO Auto-generated method stub
		return String.format("id[%s]", id);
	}
}
=======
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
		// TODO Auto-generated method stub
		return String.format("id[%s]", id);
	}
}
>>>>>>> 1175f7c9c56abddb3e3d29a5bcd8bfd113d7bedc
