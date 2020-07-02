package com.app.recipe.dao;

import com.app.recipe.model.RegisterDto;

public interface RegisterDAO {
	public void update(RegisterDto dto);
	public RegisterDto select(String id);
	public RegisterDto select(String id, String auth);
	public RegisterDto select_login(String id, String pw);
	public void insert(RegisterDto dto);
	public int chef_select(); // ���� ��ȸ��
}
