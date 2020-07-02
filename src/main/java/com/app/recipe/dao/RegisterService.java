package com.app.recipe.dao;

import com.app.recipe.model.RegisterDto;

public interface RegisterService {
	public void register(RegisterDto dto);
	public boolean idcheck(String id);
	public boolean idcheck(String email, String auth);
	public boolean dicecheck(String id, String dice);
	public void update(RegisterDto dto);
	public RegisterDto select(String id);
	public RegisterDto select(String email, String auth);
	public RegisterDto login(String id, String pw);
}
