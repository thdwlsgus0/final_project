package com.app.recipe.dao;

import com.app.recipe.model.RegisterDto;

public interface RegisterDAO {
	public boolean update(RegisterDto dto);
	public RegisterDto select(String id);
	public RegisterDto select(String email, String auth);
	public RegisterDto select_login(String id, String pw);
<<<<<<< HEAD
	public void insert(RegisterDto dto);
	public int chef_select(); // ���� ��ȸ��
=======
	public RegisterDto select_login_auth(String email, String auth, String pw);
	public boolean insert(RegisterDto dto);
>>>>>>> origin/chanhyung
}
