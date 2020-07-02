package com.app.recipe.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAOImpl implements RecipeDAO{
	@Inject
	SqlSession sql;
	
	// 레시피 총 개수
	@Override
	public int recipe_select() {
		System.out.println("DAO호출");
		return sql.selectOne("recipeDTO.selectcnt");
	}
   
	// 레시피 조회수 총 개수
	@Override
	public int recipe_total_select() {
	   return sql.selectOne("recipeDTO.select_total_cnt");
	}

	@Override
	public int recipe_food_result(String food_name) {
		return sql.selectOne("recipeDTO.select_food_cnt", food_name);
	}
}
