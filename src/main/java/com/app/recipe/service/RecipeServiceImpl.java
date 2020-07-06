package com.app.recipe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.app.recipe.dao.RecipeDAO;
import com.app.recipe.model.RecipeDTO;

@Service
public class RecipeServiceImpl implements RecipeService {
	
// >>>>> merge
	
	@Inject
	private RecipeDAO dao;
	
	// 4. 이지원 수정
//	@Override
//	public int recipe_select() {
//		System.out.println("serviceȣ��");
//		return dao.recipe_select();
//	}

	// 송진현 추가 : 총 레시피 조회수(hit) 조회
	@Override
	public int recipe_total_select() {
		return dao.recipe_total_select();
	}

	// 4. 이지원 수정
//	@Override
//	public int recipe_food_result(String keyword) {
//		System.out.println("hi");
//		return dao.recipe_food_result(keyword);
//	}

	// 5. 이지원 수정
//	@Override
//	public int getTotalArticle() {
//		return dao.getTotalArticle();
//	}
//	
//	@Override
//	public int getTotalArticle(String keyword) {
//		return dao.getTotalArticle(keyword);
//	}
	
	@Override
	public int getTotalArticle(String mem_id, String keyword, String options) {
		return dao.getTotalArticle(mem_id, keyword, options);
	}

	// 4. 이지원 수정
//	@Override
//	public List<RecipeDTO> getRecipeList(int startNum, int endNum) {
//		return dao.getRecipeList(startNum, endNum);
//	}
	
	@Override
	public List<RecipeDTO> getRecipeList(int startNum, int endNum, String mem_id, String keyword, String options) {
		return dao.getRecipeList(startNum, endNum, mem_id, keyword, options);
	}

	// 4. 이지원 수정
//	@Override
//	public List<RecipeDTO> getKeywordList(int startNum, int endNum, String keyword) {
//        return dao.getKeywordList(startNum, endNum, keyword);
//	}
	
	// 4. 이지원 수정
//	@Override
//	public List<RecipeDTO> getAllList(int startNum, int endNum) {
//		return dao.getAllList(startNum, endNum);
//	}
	
	@Override
	public int getRecipeCount(String mem_id) {
		return dao.getRecipeCount(mem_id);
	}
}
