package com.app.recipe.service;

import java.util.List;

import com.app.recipe.model.RecipeCmtDTO;

public interface RecipeCmtService {
	public int deleteCmt(RecipeCmtDTO dto);			// 자식 댓글 수가 1 보다 작을 때 삭제
	public int getChildernCnt(RecipeCmtDTO dto);	// 삭제 동작하기 전에 삭제 대상 댓글의 자식 댓글의 수를 구함
	public int modifyCmt(RecipeCmtDTO dto);
	public int writeCmt(RecipeCmtDTO dto);
	public int getTotalRecipeCmt(int recipe_seq);
	public List<RecipeCmtDTO> getRecipeCmtList(int recipe_seq);
}
