package com.app.recipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.recipe.model.RecipeDTO;

public interface RecipeDAO {
	public int recipe_select(); 
	public int recipe_total_select();
	public int recipe_food_result(String keyword);
	public List<RecipeDTO> getKeywordList(int startNum, int endNum,  String keyword);
	public List<RecipeDTO> getAllList(int startNum, int endNum);
	public int updateRecipe(RecipeDTO recipeDTO);
	public int insertRecipe(RecipeDTO recipeDTO);
	public int getTotalArticle(String keyword);
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword);
	public RecipeDTO getRecipeView(int seq);
	
}
