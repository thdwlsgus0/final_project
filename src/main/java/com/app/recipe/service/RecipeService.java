package com.app.recipe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.recipe.model.RecipeDTO;

public interface RecipeService {
	public int recipe_select(); 
	public int recipe_total_select(); 
	public int recipe_food_result(String keyword); 
	public List<RecipeDTO> getKeywordList(int startNum, int endNum, String keyword);
	public List<RecipeDTO> getAllList(int startNum, int endNum);
	public int getTotalArticle(String keyword);
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword);

}
