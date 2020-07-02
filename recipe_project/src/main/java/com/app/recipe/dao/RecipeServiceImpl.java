package com.app.recipe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.recipe.model.RecipeDTO;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeDAO recipeDAO;
	
	@Override
	public int getTotalArticle(String keyword) {
		return recipeDAO.getTotalArticle(keyword);
	}
	
	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword) {
		return recipeDAO.getRecipeList(startNum, endNum, mem_id, keyword);
	}

}
