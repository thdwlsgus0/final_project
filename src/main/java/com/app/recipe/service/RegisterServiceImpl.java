package com.app.recipe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.app.recipe.dao.RegisterDAO;
import com.app.recipe.model.RegisterDto;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Inject
	RegisterDAO dao;
	
	@Override
	public void register(RegisterDto dto) {
		dto.setId(dto.getId().trim());
		dao.insert(dto);
	}

	@Override
	public boolean idcheck(String id) {
		if(dao.select(id) == null) return true;
		return false;
	}
	
	@Override
	public boolean idcheck(String id, String auth) {
		if(dao.select(id, auth) == null) return true;
		return false;
	}

	@Override
	public boolean login(RegisterDto dto) {
		if(dao.select(dto.getId()).getCheck().equals("T")) return true;
		else return false;
	}

	@Override
	public boolean dicecheck(String id, String dice) {
		if(dao.select(id).getCheck().equals(dice)) return true;
		return false;
	}

	@Override
	public void update(RegisterDto dto) {
		dao.update(dto);
	}

	@Override
	public RegisterDto select(String id) {
		return dao.select(id);
	}
	
	@Override
	public RegisterDto select(String id, String pw) {
		return dao.select_login(id, pw);
	}
	public int chef_select() {
		return dao.chef_select();
	}
}
