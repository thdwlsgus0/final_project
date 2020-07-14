package com.app.recipe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.app.recipe.dao.RecipeDAO;
import com.app.recipe.model.RecipeDTO;
import com.app.recipe.model.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeDAO dao;

	@Override
	public void updatehit(int seq) {
		dao.updatehit(seq);
	}

	@Override
	public RecipeDTO getRecipe(int seq) {
		return dao.getRecipeView(seq);
	}

	@Override
	public int recipe_total_select() {
		return dao.recipe_total_select();
	}

	@Override
	public int getTotalArticle(String mem_id, String keyword, String options) {
		return dao.getTotalArticle(mem_id, keyword, options);
	}

	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword, String options) {
		return dao.getRecipeList(startNum, endNum, mem_id, keyword, options);
	}

	@Override
	public List<RecipeVO> getChefListMap() {
		return dao.getChefListMap();
	}

	@Override
	public List<RecipeVO> getRecentListMap() {
		return dao.getRecentListMap();
	}

	@Override
	public List<RecipeVO> getRecentSign() {
		return dao.getRecentSign();
	}

	@Override
	public RecipeDTO getRecipe_profile(int seq) {
		return dao.getRecipe_profile(seq);
	}

	@Override
	public List<RecipeVO> getRecipeDetail_1(int seq) {
		return dao.getRecipeDetail_1(seq);
	}

	@Override
	public List<RecipeVO> getRecipeDetail_2(int seq) {
		return dao.getRecipeDetail_2(seq);
	}

	@Override
	public List<RecipeVO> getRecipeDetail_3(int seq) {
		return dao.getRecipeDetail_3(seq);
	}

	@Override
	public List<RecipeVO> getRecipeDetail_4(int seq) {
		return dao.getRecipeDetail_4(seq);
	}
}
