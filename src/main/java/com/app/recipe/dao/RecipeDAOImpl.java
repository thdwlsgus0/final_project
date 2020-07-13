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
import com.app.recipe.model.RecipeVO;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

	@Inject
	SqlSession sql;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int recipe_total_select() {
		return sql.selectOne("recipe.select_total_cnt");
	}

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
		return sqlSessionTemplate.selectOne("recipe.getone",seq);
	}

	@Override
	public int getRecipeCount(String mem_id) {
		return sqlSessionTemplate.selectOne("recipe.getRecipeCount", mem_id);
	}

	@Override
	public List<RecipeVO> getChefListMap() {
		List<RecipeVO> temp = sqlSessionTemplate.selectList("getChefListMap");
		
		return temp;
	}

	@Override
	public List<RecipeVO> getRecentListMap() {
		List<RecipeVO> foo = sqlSessionTemplate.selectList("getRecentListMap");
		return foo;
	}

	@Override
	public List<RecipeVO> getRecentSign() {
		List<RecipeVO> doo = sqlSessionTemplate.selectList("getRecentSign");
		return doo;
	}

	@Override
	public void updatehit(int seq) {
		sql.update("recipe.updateCount",seq);
	}

	@Override
	public RecipeDTO getRecipe_profile(int seq) {
		return sqlSessionTemplate.selectOne("recipe.gettwo",seq);
	}

	@Override
	public List<RecipeVO> getRecipeDetail_1(int seq) {
		List<RecipeVO> poo_1 = sqlSessionTemplate.selectList("getRecipeDetail_1",seq);
		return poo_1;
	}

	@Override
	public List<RecipeVO> getRecipeDetail_2(int seq) {
		List<RecipeVO> poo_2 = sqlSessionTemplate.selectList("getRecipeDetail_2",seq);
		return poo_2;
	}

	@Override
	public List<RecipeVO> getRecipeDetail_3(int seq) {
		List<RecipeVO> poo_3 = sqlSessionTemplate.selectList("getRecipeDetail_3",seq);
		return poo_3;
	}

	@Override
	public List<RecipeVO> getRecipeDetail_4(int seq) {
		List<RecipeVO> poo_4 = sqlSessionTemplate.selectList("getRecipeDetail_4",seq);
		return poo_4;
	}
}
