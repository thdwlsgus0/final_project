package com.app.recipe.dao;

import java.util.List;

import com.app.recipe.model.RecipeDTO;

public interface RecipeDAO {
	public int recipe_select(); 
	public int recipe_total_select();
	public int recipe_food_result(String keyword);
	public List<RecipeDTO> getKeywordList(int startNum, int endNum,  String keyword);
	public List<RecipeDTO> getAllList(int startNum, int endNum);
	public int updateRecipe(RecipeDTO recipeDTO);
	public int insertRecipe(RecipeDTO recipeDTO);
	public int getTotalArticle();
	public int getTotalArticle(String keyword);
	public int getTotalArticle(String mem_id, String keyword);
	public List<RecipeDTO> getRecipeList(int startNum, int endNum);
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword);
	public RecipeDTO getRecipeView(int seq);
	public int getRecipeCount(String mem_id);
}