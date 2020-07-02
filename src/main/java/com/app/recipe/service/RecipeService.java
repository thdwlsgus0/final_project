package com.app.recipe.service;

public interface RecipeService {
	public int recipe_select(); // 레시피 조회수
	public int recipe_total_select(); // 레시피 총 조회수
	public int recipe_food_result(String food_name); // 레시피 음식 결과
}
