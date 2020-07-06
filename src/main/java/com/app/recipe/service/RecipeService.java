package com.app.recipe.service;

import java.util.List;

import com.app.recipe.model.RecipeDTO;

public interface RecipeService {
//	public int recipe_select(); // 4. 이지원 수정
	public int recipe_total_select(); // 송진현 추가 : 총 레시피 조회수(hit) 조회 
//	public int recipe_food_result(String keyword); // 4. 이지원 수정
//	public List<RecipeDTO> getKeywordList(int startNum, int endNum, String keyword); // 4. 이지원 수정
//	public List<RecipeDTO> getAllList(int startNum, int endNum);	// 4. 이지원 수정
//	public int getTotalArticle();					// 5. 이지원 수정
//	public int getTotalArticle(String keyword);		// 5. 이지원 수정
	public int getTotalArticle(String mem_id, String keyword, String options);
//	public List<RecipeDTO> getRecipeList(int startNum, int endNum); // 4. 이지원 수정
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword, String options);
	public int getRecipeCount(String mem_id);
}
