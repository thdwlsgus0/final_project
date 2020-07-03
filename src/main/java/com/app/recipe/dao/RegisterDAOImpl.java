package com.app.recipe.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.recipe.model.RegisterDto;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterDAOImpl.class);

	@Inject
	SqlSession sql;
	
	@Override
	public boolean update(RegisterDto dto) {
		try {
			sql.update("regi.update", dto);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public RegisterDto select(String id) {
		return sql.selectOne("regi.select", id);
	}
	
	@Override
	public RegisterDto select(String email, String auth) {
		return sql.selectOne("regi.selectauth", new RegisterDto(email, auth));
	}
	
	@Override
	public RegisterDto select_login(String id, String pw) {
		return sql.selectOne("regi.selectori", new RegisterDto(id, pw, false));
	}
	
	@Override
	public RegisterDto select_login_auth(String email, String auth, String pw) {
		return sql.selectOne("regi.selectoriauth", new RegisterDto(email, auth, pw));
	}

	@Override
	public boolean insert(RegisterDto dto) {
		if(dto.getCheck().length() > 100) {
			logger.warn("register [{}] dice value over 100: [{}]", dto.getEmail(), dto.getCheck());
			return false;
		}
		dto.setId(dto.getId().trim());
		sql.insert("regi.insert", dto);
		return true;
	}
}
