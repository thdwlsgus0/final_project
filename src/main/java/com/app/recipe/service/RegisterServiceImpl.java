package com.app.recipe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.app.recipe.dao.RegisterDAO;
import com.app.recipe.model.MemberVO;
import com.app.recipe.model.RegisterDto;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Inject
	RegisterDAO dao;
	
	@Override
	public void register(RegisterDto dto) {
		dao.insert(dto);
	}

	@Override
	public boolean idcheck(String id) {
		if(dao.select(id) == null) return true;
		return false;
	}
	
	@Override
	public boolean idcheck(String email, String auth) {
		if(dao.select(email, auth) == null) return true;
		return false;
	}

	@Override
	public MemberVO securitylogin(String id) {
		return dao.securitylogin(id);
	}

	@Override
	public boolean dicecheck(String id, String dice) {
		RegisterDto dto = dao.select(id);
		if(dto == null) return false;
		else if(dto.getCheck().equals(dice)) return true;
		else return false;
	}

	@Override
	public boolean update(RegisterDto dto) {
		return dao.update(dto);
	}

	@Override
	public RegisterDto select(String id) {
		return dao.select(id);
	}
	
	@Override
	public RegisterDto login(String id, String pw) {
		return dao.select_login(id, pw);
	}

	@Override
	public RegisterDto select(String email, String auth) {
		return dao.select(email, auth);
	}
	
	@Override
	public int chef_select() {
		return dao.chef_select();
	}
	
	
}
