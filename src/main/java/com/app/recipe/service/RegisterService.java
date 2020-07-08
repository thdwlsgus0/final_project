package com.app.recipe.service;

import com.app.recipe.model.MemberVO;
import com.app.recipe.model.RegisterDto;

public interface RegisterService {
	public void register(RegisterDto dto);
	public boolean idcheck(String id);
	public boolean idcheck(String email, String auth);
	public boolean dicecheck(String id, String dice);
	public boolean update(RegisterDto dto);
	public RegisterDto select(String id);
	public RegisterDto select(String email, String auth);
	public RegisterDto login(String id, String pw);
	public int chef_select();
	public MemberVO securitylogin(String id);
}
