package com.app.recipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.recipe.model.RecipeDTO;

@Repository
public class RecipeDAOImpl implements RecipeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int updateRecipe(RecipeDTO recipeDTO) {
		return 0;
	}

	@Override
	public int insertRecipe(RecipeDTO recipeDTO) {
		return 0;
	}
	

	@Override
	public int getgetTotalArticle() {
		return sqlSessionTemplate.selectOne("recipe.getTotalArticle");
	}

	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSessionTemplate.selectList("recipe.getRecipeList", map);
	}

	@Override
	public RecipeDTO getRecipeView(int seq) {
		return null;
	}

	@Override
	public int getRecipeCount(String mem_id) {
		return sqlSessionTemplate.selectOne("recipe.getRecipeCount",mem_id);
	}
	
}
