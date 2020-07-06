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

	// 4. 이지원 수정
//	@Override
//	public int recipe_select() {
//		return sql.selectOne("recipe.selectcnt");
//	}

	// 송진현 추가 : 총 레시피 조회수(hit) 조회
	@Override
	public int recipe_total_select() {
		return sql.selectOne("recipe.select_total_cnt");
	}

	// 4. 이지원 수정
//	@Override
//	public int recipe_food_result(String keyword) {
//		return sql.selectOne("recipe.select_food_cnt", keyword);
//	}

	// 5. 이지원 수정
//	@Override
//	public int updateRecipe(RecipeDTO recipeDTO) {
//		return 0;
//	}
//
//	@Override
//	public int insertRecipe(RecipeDTO recipeDTO) {
//		return 0;
//	}
//
//	@Override
//	public int getTotalArticle() {
//		return sqlSessionTemplate.selectOne("recipe.getTotalArticle");
//	}
//	@Override
//	public int getTotalArticle(String keyword) {
//		return sqlSessionTemplate.selectOne("recipe.getTotalArticle", keyword);
//	}
	@Override
	public int getTotalArticle(String mem_id, String keyword, String options) {
		System.out.println("mem_id :" + mem_id);
		System.out.println("mem_id.equals('dao') :" + mem_id.equals(""));
		Map<String, Object> map = new HashMap<>();
		map.put("mem_id", mem_id);
		map.put("keyword", keyword);
		map.put("options", options);
		return sqlSessionTemplate.selectOne("recipe.getTotalArticle", map);
	}

	// 4. 이지원 수정
//	@Override
//	public List<RecipeDTO> getRecipeList(int startNum, int endNum) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("startNum", startNum);
//		map.put("endNum", endNum);
//		
//		return sqlSessionTemplate.selectList("recipe.getRecipeList", map);
//	}
	
	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword, String options) {
		Map<String, Object> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("mem_id", mem_id);
		map.put("keyword", keyword);
		map.put("options", options);
		
		return sqlSessionTemplate.selectList("recipe.getRecipeList", map);
	}

	@Override
	public RecipeDTO getRecipeView(int seq) {
		return null;
	}

	// 4. 이지원 수정
//	@Override
//	public List<RecipeDTO> getKeywordList(int startNum, int endNum, String keyword) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("startNum", startNum);
//		map.put("endNum", endNum);
//		map.put("keyword", keyword);
//		return sqlSessionTemplate.selectList("recipe.getKeywordList", map);
//	}
	// 4. 이지원 수정
//	public List<RecipeDTO> getAllList(int startNum, int endNum) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("startNum", startNum);
//		map.put("endNum", endNum);
//		System.out.println("sql ���� ����");
//		return sqlSessionTemplate.selectList("recipe.getAllList", map);
//	}
	
	@Override
	public int getRecipeCount(String mem_id) {
		return sqlSessionTemplate.selectOne("recipe.getRecipeCount",mem_id);
	}	
}
