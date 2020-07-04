package com.app.recipe.service;

import com.app.recipe.model.RegisterDto;

public interface RegisterService {
	public void register(RegisterDto dto);
	public boolean idcheck(String id);
	public boolean idcheck(String email, String auth);
	public boolean dicecheck(String id, String dice);
	public boolean update(RegisterDto dto);
	public RegisterDto select(String id);
<<<<<<< HEAD:src/main/java/com/app/recipe/service/RegisterService.java
	public RegisterDto select(String id, String pw);
	public int chef_select();
=======
	public RegisterDto select(String email, String auth);
	public RegisterDto login(String id, String pw);
>>>>>>> origin/chanhyung:src/main/java/com/app/recipe/dao/RegisterService.java
}
