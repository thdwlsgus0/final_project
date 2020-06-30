package com.app.recipe.dao;

import com.app.recipe.model.RegisterDto;

public interface RegisterDAO {
	public void update(RegisterDto dto);
	public RegisterDto select(String id);
	public void insert(RegisterDto dto);
}
