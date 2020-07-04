package com.app.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.service.RecipeService;
import com.app.recipe.model.RecipeDTO;

@Controller
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	
	@RequestMapping(value = "/cook/chef.do", method=RequestMethod.GET)
	public ModelAndView getRecipeList(HttpServletRequest request) {
		// 데이터 처리
		String str_pg = request.getParameter("pg");
		int pg = 1;
		
		if(str_pg != null) {
			if(str_pg != "") {
				if(str_pg.matches("^[0-9]*$")) {
					pg = Integer.parseInt(str_pg);
				}
			}
		}
		
		/* DB 작업 */
		// 목록에 보여질 게시글 최소/최대 개수(최대 20개)
		int endNum = pg * 20;
		int startNum = endNum - 19;
		
		// RecipeDAOImpl recipeDAOImpl = new RecipeDAOImpl();
		List<RecipeDTO> list = recipeService.getRecipeList(startNum, endNum);		
		
		// 페이징 처리
		int totalA = recipeService.getTotalArticle();
		int totalP = (totalA+(20-1))/20;	// 'total Page' : 총 페이지 수
			
		// 페이지 블럭을 최대 5개까지 표시
		int startPage = (pg-1)/5*5+1;
		int endPage = startPage + 4;
		if(endPage > totalP) 
			endPage = totalP;
		
		// 데이터 공유
		ModelAndView mv = new ModelAndView();
		mv.addObject("pg", pg);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		// 화면 네비게이션
		mv.setViewName("/cook/chef.jsp");
		
		return mv;
		
	}
}