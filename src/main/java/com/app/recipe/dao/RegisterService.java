package com.app.recipe.dao;

import com.app.recipe.model.RegisterDto;

public interface RegisterService {
	public void register(RegisterDto dto);
	public boolean idcheck(String id);
	public boolean login(RegisterDto dto);
}
