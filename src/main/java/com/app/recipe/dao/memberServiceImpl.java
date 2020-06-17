package com.app.recipe.dao;

import javax.inject.Inject;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.recipe.model.memberDTO;
@Service
public class memberServiceImpl implements memberService {

	@Inject
	memberDAO memberdao; // dao를 사용하기 위해 의존성을 주입
	private JavaMailSender mailSender;
	
	@Override
	public void authentication(memberDTO dto) {
		
	}
  
}