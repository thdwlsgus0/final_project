package com.app.recipe.dao;

import java.util.List;

import com.app.recipe.model.RecipeCmtDTO;

public interface RecipeCmtDAO {
	public int deleteCmt(RecipeCmtDTO dto);
	public int getChildernCnt(RecipeCmtDTO dto);
	public int modifyCmt(RecipeCmtDTO dto);
	public int writeCmt(RecipeCmtDTO dto);
	public int getTotalRecipeCmt(int recipe_seq);
	public List<RecipeCmtDTO> getRecipeCmtList(int recipe_seq);
}