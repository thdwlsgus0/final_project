package com.app.recipe.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.app.recipe.model.RegisterDto;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Inject
	SqlSession sql;
	
	@Override
	public void update(RegisterDto dto) {
		sql.update("regi.update", dto);
	}

	@Override
	public RegisterDto select(RegisterDto dto) {
		return sql.selectOne("regi.select", dto);
	}

	@Override
	public void insert(RegisterDto dto) {
		dto.setCheck("F"); //이메일 인증 여부: F
		sql.insert("regi.insert", dto);
	}
}
