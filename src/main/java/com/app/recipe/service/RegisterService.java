package com.app.recipe.service;

import com.app.recipe.model.RegisterDto;

public interface RegisterService {
	public void register(RegisterDto dto);
	public boolean idcheck(String id);
	public boolean idcheck(String id, String auth);
	public boolean login(RegisterDto dto);
	public boolean dicecheck(String id, String dice);
	public void update(RegisterDto dto);
	public RegisterDto select(String id);
	public RegisterDto select(String id, String pw);
	public int chef_select();
}
