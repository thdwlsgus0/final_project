package com.app.recipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.recipe.model.RecipeDTO;

@Repository
public class RecipeDAOImpl implements RecipeDAO {
	
	@Inject
	SqlSession sql;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


	@Override
	public int recipe_select() {
		return sql.selectOne("recipe.selectcnt");
	}


	@Override
	public int recipe_total_select() {
		return sql.selectOne("recipe.select_total_cnt");
	}

	@Override
	public int recipe_food_result(String keyword) {
		return sql.selectOne("recipe.select_food_cnt", keyword);
	}

	@Override
	public int updateRecipe(RecipeDTO recipeDTO) {
		return 0;
	}

	@Override
	public int insertRecipe(RecipeDTO recipeDTO) {
		return 0;
	}

	@Override
	public int getTotalArticle() {
		return sqlSessionTemplate.selectOne("recipe.getTotalArticle");
	}
	@Override
	public int getTotalArticle(String keyword) {
		return sqlSessionTemplate.selectOne("recipe.getTotalArticle", keyword);
	}

	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSessionTemplate.selectList("recipe.getRecipeList", map);
	}
	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("mem_id", mem_id);
		map.put("keyword", keyword);
		System.out.println("에러 확인");
		return sqlSessionTemplate.selectList("recipe.getRecipeList", map);
	}

	@Override
	public RecipeDTO getRecipeView(int seq) {
		return null;
	}

	@Override
	public List<RecipeDTO> getKeywordList(int startNum, int endNum, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectList("recipe.getKeywordList", map);
	}
	public List<RecipeDTO> getAllList(int startNum, int endNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		System.out.println("sql 쿼리 접근");
		return sqlSessionTemplate.selectList("recipe.getAllList", map);
	}
	
	@Override
	public int getRecipeCount(String mem_id) {
		return sqlSessionTemplate.selectOne("recipe.getRecipeCount",mem_id);
	}
	
}
