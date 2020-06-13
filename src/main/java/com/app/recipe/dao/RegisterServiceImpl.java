package com.app.recipe.dao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	public boolean idcheck(RegisterDto dto) {
		if(dao.select(dto) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(RegisterDto dto) {
		if(dao.select(dto).getCheck().equals("T")) {
			//�̸��� �����ߴٸ� true��ȯ
			return true;
		}
		return false;
	}
}
