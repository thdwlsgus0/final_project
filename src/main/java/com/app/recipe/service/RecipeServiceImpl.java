package com.app.recipe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.app.recipe.dao.RecipeDAO;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Inject
	RecipeDAO dao;
	
	public int recipe_select() {
		System.out.println("service»£√‚");
		return dao.recipe_select();
	}

	@Override
	public int recipe_total_select() {
		return dao.recipe_total_select();
	}

	@Override
	public int recipe_food_result(String food_name) {
		return dao.recipe_food_result(food_name);
	}
}
