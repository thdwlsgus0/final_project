package com.app.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.recipe.dao.RecipeDAO;
import com.app.recipe.model.RecipeDTO;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeDAO recipeDAO;
	
	@Override
	public int getTotalArticle() {
		return recipeDAO.getgetTotalArticle();
	}
	
	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum) {
		return recipeDAO.getRecipeList(startNum, endNum);
	}

	@Override
	public int getRecipeCount(String mem_id) {
		return recipeDAO.getRecipeCount(mem_id);
	}
}
