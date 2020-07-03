package com.app.recipe.dao;

import java.util.ArrayList;
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
	public int getTotalArticle(String mem_id, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("mem_id", mem_id);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectOne("recipe.getTotalArticle", map);
	}

	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("mem_id", mem_id);
		map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectList("recipe.getRecipeList", map);
	}

	@Override
	public RecipeDTO getRecipeView(int seq) {
		return null;
	}

}
