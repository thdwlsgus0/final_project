package com.app.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.dao.RecipeService;
import com.app.recipe.model.RecipeDTO;

@Controller
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	
	@RequestMapping(value = "/cook/chef.do", method=RequestMethod.GET)
	public ModelAndView getRecipeList(HttpServletRequest request, 
									@RequestParam(defaultValue = "") String keyword) {
		// 데이터 처리
		String str_pg = request.getParameter("pg");
		String mem_id = request.getParameter("mem_id");
//		String mem_id = "이지원";
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
		List<RecipeDTO> list = recipeService.getRecipeList(startNum, endNum, mem_id, keyword);
		
		// 페이징 처리
		int totalA = recipeService.getTotalArticle(mem_id, keyword);
		int totalP = (totalA+(20-1))/20;	// 'total Page' : 총 페이지 수
		
		// 페이지 블럭을 최대 5개까지 표시
		int startPage = (pg-1)/5*5+1;
		int endPage = startPage + 4;
		if(endPage > totalP) 
			endPage = totalP;
		
		// 데이터 공유
		ModelAndView mv = new ModelAndView();
		mv.addObject("mem_id", mem_id);
		mv.addObject("pg", pg);
		mv.addObject("keyword", keyword);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP);			// 총 페이지 수
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);		// 총 게시물 수에 의한 마지막 페이지 수
		
		// 화면 네비게이션
		mv.setViewName("/cook/chef.jsp");
		
		return mv;
		
	}

}
