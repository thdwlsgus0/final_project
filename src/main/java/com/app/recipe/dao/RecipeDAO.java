package com.app.recipe.dao;

import java.util.List;

import com.app.recipe.model.RecipeDTO;

public interface RecipeDAO {
	public int updateRecipe(RecipeDTO recipeDTO);
	public int insertRecipe(RecipeDTO recipeDTO);
	public int getgetTotalArticle();
	public List<RecipeDTO> getRecipeList(int startNum, int endNum);
	public RecipeDTO getRecipeView(int seq);
	/* 멤버의 레시피 수 카운트*/
	public int getRecipeCount(String mem_id);
}