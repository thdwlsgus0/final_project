package com.app.recipe.service;

import java.util.List;

import com.app.recipe.model.RecipeDTO;

public interface RecipeService {
	public int getTotalArticle();
	public List<RecipeDTO> getRecipeList(int startNum, int endNum);
	public int getRecipeCount(String mem_id);
}
