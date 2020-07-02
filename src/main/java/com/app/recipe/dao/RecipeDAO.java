package com.app.recipe.dao;

public interface RecipeDAO {
	public int recipe_select(); // 레시피 조회수
	public int recipe_total_select(); // 총 레시피 개수
	public int recipe_food_result(String food_name); // 레시피 음식 결과
}
