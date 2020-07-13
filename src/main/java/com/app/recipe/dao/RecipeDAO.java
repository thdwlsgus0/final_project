package com.app.recipe.dao;

import java.util.List;

import com.app.recipe.model.RecipeDTO;
import com.app.recipe.model.RecipeVO;

public interface RecipeDAO {
	public int recipe_total_select();
	public int getTotalArticle(String mem_id, String keyword, String options);
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword, String options);
	public RecipeDTO getRecipeView(int seq);
	public int getRecipeCount(String mem_id);
	
	public List<RecipeVO> getChefListMap();
	public List<RecipeVO> getRecentListMap();
	public List<RecipeVO> getRecentSign();
	public void updatehit(int seq);
	public RecipeDTO getRecipe_profile(int seq);
	public List<RecipeVO> getRecipeDetail_1(int seq);
	public List<RecipeVO> getRecipeDetail_2(int seq);
	public List<RecipeVO> getRecipeDetail_3(int seq);
	public List<RecipeVO> getRecipeDetail_4(int seq);
}