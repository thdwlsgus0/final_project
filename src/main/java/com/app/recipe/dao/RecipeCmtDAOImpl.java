package com.app.recipe.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.app.recipe.model.RecipeCmtDTO;

@Repository
public class RecipeCmtDAOImpl implements RecipeCmtDAO {
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteCmt(RecipeCmtDTO dto) {
		return sqlSessionTemplate.delete("cmt.deleteRecipeCmt", dto);
	}
	
	@Override
	public int getChildernCnt(RecipeCmtDTO dto) {
		return sqlSessionTemplate.selectOne("cmt.getChildernCnt", dto);
	}
	
	@Override
	public int modifyCmt(RecipeCmtDTO dto) {
		return sqlSessionTemplate.update("cmt.modifyRecipeCmt", dto);
	}
	
	@Override
	public int writeCmt(RecipeCmtDTO dto) {
		return sqlSessionTemplate.insert("cmt.writeRecipeCmt", dto);
	}
	
	@Override
	public int getTotalRecipeCmt(int recipe_seq) {
		return sqlSessionTemplate.selectOne("cmt.getTotalRecipeCmt", recipe_seq);
	}

	@Override
	public List<RecipeCmtDTO> getRecipeCmtList(int recipe_seq) {
		return sqlSessionTemplate.selectList("cmt.getRecipeCmtList", recipe_seq);
	}

}
