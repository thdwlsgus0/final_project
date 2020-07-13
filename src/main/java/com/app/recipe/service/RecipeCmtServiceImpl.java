package com.app.recipe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.app.recipe.dao.RecipeCmtDAO;
import com.app.recipe.model.RecipeCmtDTO;

@Service
public class RecipeCmtServiceImpl implements RecipeCmtService {
	@Inject
	private RecipeCmtDAO dao;
	
	@Override
	public int deleteCmt(RecipeCmtDTO dto) {
		return dao.deleteCmt(dto);
	}

	@Override
	public int getChildernCnt(RecipeCmtDTO dto) {
		System.out.println("이지이지2 : " + dto);
		System.out.println("이지이지5 : " + dao.getChildernCnt(dto));
		return dao.getChildernCnt(dto);
	}
	
	@Override
	public int modifyCmt(RecipeCmtDTO dto) {
		return dao.modifyCmt(dto);
	}

	@Override
	public int writeCmt(RecipeCmtDTO dto) {
		return dao.writeCmt(dto);
	}
	
	@Override
	public int getTotalRecipeCmt(int recipe_seq) {
		return dao.getTotalRecipeCmt(recipe_seq);
	}
	
	@Override
	public List<RecipeCmtDTO> getRecipeCmtList(int recipe_seq) {
		return dao.getRecipeCmtList(recipe_seq);
	}
}
