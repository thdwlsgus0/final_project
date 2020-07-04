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
	public RegisterDto select(String id) {
		return sql.selectOne("regi.select", id);
	}
	
	@Override
	public RegisterDto select(String id, String auth) {
		return sql.selectOne("regi.selectauth", new RegisterDto(id, auth));
	}

	@Override
	public void insert(RegisterDto dto) {
		sql.insert("regi.insert", dto);
	}
}