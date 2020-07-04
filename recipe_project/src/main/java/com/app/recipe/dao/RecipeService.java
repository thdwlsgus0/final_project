package com.app.recipe.dao;

import java.util.List;

import com.app.recipe.model.RecipeDTO;

public interface RecipeService {
	public int getTotalArticle(String mem_id, String keyword);
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword);
}
