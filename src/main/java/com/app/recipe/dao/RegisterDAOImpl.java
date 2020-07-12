package com.app.recipe.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.app.recipe.model.MemberVO;
import com.app.recipe.model.RegisterDto;
import com.app.recipe.util.member.RegistInit;
import com.app.recipe.util.member.RegistUtil;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterDAOImpl.class);

	@Inject SqlSession sql;
	@Inject BCryptPasswordEncoder encoder;
	
	@Override
	public MemberVO securitylogin(String id) {
		return sql.selectOne("login", id);
	}

	@Override
	public boolean update(RegisterDto dto) {
		try {
			RegisterDto ori = select(dto.getId());
			if(!ori.getPw().equals(dto.getPw())) {
				dto.setPw(encoder.encode(dto.getPw()));
			}
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
	public int chef_select() {
	   return sql.selectOne("regi.selectcnt");
	}

	@Override
	public boolean insert(RegisterDto dto) {
		try {
			if(dto.getAuth() != null && dto.getAuth().length() > 0) {
				dto.setId(dto.getId() + RegistUtil.randomint());
			}
			dto.setId(dto.getId().trim());
			dto.setPw(encoder.encode(dto.getPw()));
			sql.insert("regi.insert", dto);
			sql.insert("regi.insertauth", dto.getId());
			RegistInit.user_rating_init(dto.getId());
		} catch(Exception e){
			return false;
		}
		return true;
	}
}
