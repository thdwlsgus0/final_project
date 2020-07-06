package com.app.recipe.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.service.RecipeService;
import com.app.recipe.model.RecipeDTO;

@Controller
public class RecipeController {
	
// >>>>> merge
	
	@Inject
	private RecipeService rsc;

	// 3. 이지원 수정 : 
	// getRecipeList와 method_page의 페이징 처리를 
	// 하나의 sql로 처리하기 위해 파라미터 추가(mem_id)
	// 8-2. 이지원 수정
	private HashMap<String, Integer> get_page(String str_pg, String mem_id, String keyword, String options) {
		// 데이터 처리
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int pg = 1;

		if (str_pg != null) {
			if (str_pg != "") {
				if (str_pg.matches("^[0-9]*$")) {
					pg = Integer.parseInt(str_pg);
				}
			}
		}
		hm.put("pg", pg);
		/* DB 작업 */
		// 목록에 보여질 게시글 최소/최대 개수(최대 20개)
		int endNum = pg * 20;
		hm.put("endNum", endNum);
		int startNum = endNum - 19;
		hm.put("startNum", startNum);

		// 페이징 처리
		// 2. 이지원 수정
		// 8-2. 이지원 수정
		int totalA = rsc.getTotalArticle(mem_id, keyword, options);
		hm.put("totalA", totalA);
		int totalP = (totalA + (20 - 1)) / 20; // 'total Page' : 총 페이지 수
		hm.put("totalP", totalP);
		// 페이지 블럭을 최대 5개까지 표시
		int startPage = (pg - 1) / 5 * 5 + 1;
		hm.put("startPage", startPage);
		int endPage = startPage + 4;
		if (endPage > totalP)
			endPage = totalP;
		hm.put("endPage", endPage);
		return hm;
	}
	
	// 2. 이지원 수정 : 파라미터로 받을 mem_id 값 ""으로 초기화
	// 8-1. 이지원 수정
	@RequestMapping(value = "/cook/chef.do", method = RequestMethod.GET)
	public ModelAndView getRecipeList(HttpServletRequest request,
									@RequestParam(defaultValue = "") String mem_id,
									@RequestParam(defaultValue = "") String keyword,
									@RequestParam(defaultValue = "") String options) {
		
		String str_pg = request.getParameter("pg");

		HashMap<String, Integer> page_hash = new HashMap<>();
		page_hash = get_page(str_pg, mem_id, keyword, options);
		
		int startNum = page_hash.get("startNum");
		int endNum = page_hash.get("endNum");
		int totalP = page_hash.get("totalP");
		int startPage = page_hash.get("startPage");
		int endPage = page_hash.get("endPage");
		int pg = page_hash.get("pg");
		// RecipeDAOImpl recipeDAOImpl = new RecipeDAOImpl();
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum, mem_id, keyword, options);

		// 데이터 공유
		ModelAndView mv = new ModelAndView();
		mv.addObject("mem_id", mem_id);
		mv.addObject("pg", pg);
		mv.addObject("keyword", keyword);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP); // 총 페이지 수
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage); // 총 게시물 수에 의한 마지막 페이지 수

		// 화면 네비게이션
		mv.setViewName("/cook/chef.jsp");
		return mv;
	}

	// 레시피
	// 2. 이지원 수정 
	// 8-1. 이지원 수정
	@RequestMapping(value = "/recipe/method.do", method = RequestMethod.GET)
	public ModelAndView method_page(HttpServletRequest request,
									@RequestParam(defaultValue = "") String mem_id,
									@RequestParam(defaultValue = "") String food,
									@RequestParam(defaultValue = "all") String options) {

		String food_name = request.getParameter("food");
		String str_pg = request.getParameter("pg");

		int food_cnt = 0;	// 이지원 수정 : food 개수 
		HashMap<String, Integer> page_hash = new HashMap<>();
		page_hash = get_page(str_pg, mem_id, food_name, options); // 8-2. 이지원 수정

		food_cnt = page_hash.get("totalA"); // 이지원 수정 : 총 게시물 수를 get_page 메소드로부터 리턴 받음.
		int startNum = page_hash.get("startNum");
		int endNum = page_hash.get("endNum");
		int totalP = page_hash.get("totalP");
		int startPage = page_hash.get("startPage");
		int endPage = page_hash.get("endPage");
		int pg = page_hash.get("pg");
		
		// 4. 이지원 수정 : 필요없는 service, dao, sql 제거 예정
//		List<RecipeDTO> list = null;
//		ModelAndView mv = new ModelAndView();
//		int food_cnt = 0;
//		if(food_name==null) {
//			food_cnt = rsc.recipe_select();
//			list = rsc.getAllList(startNum, endNum);
//		}
//	    else {
//			list = rsc.getKeywordList(startNum, endNum, food_name);
//			food_cnt = rsc.recipe_food_result(food_name);
//		}
		
		// 2. 이지원 수정
		// 8. 이지원 수정
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum, mem_id, food_name, options);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("food_cnt", food_cnt);
		mv.addObject("food_name", food_name);
		mv.addObject("pg", pg);
		mv.addObject("keyword", food_name);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP); // 총 페이지 수
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage); // 총 게시물 수에 의한 마지막 페이지 수
		mv.addObject("options", options);	// 8-3. 이지원 수정

		mv.setViewName("/recipe/method.jsp");
		return mv;
	}
	
	
// >>>>> limsh
	
	/*
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
		
		// DB 작업
		// 목록에 보여질 게시글 최소/최대 개수(최대 20개)
		int endNum = pg * 20;
		int startNum = endNum - 19;
		
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum);
		// leejiwon >>> List<RecipeDTO> list = recipeService.getRecipeList(startNum, endNum, mem_id, keyword);
		
		// 페이징 처리
		int totalA = rsc.getTotalArticle();
		// leejiwon >>> int totalA = recipeService.getTotalArticle(mem_id, keyword);
		int totalP = (totalA+(20-1))/20;	// 'total Page' : 총 페이지 수
			
		// 페이지 블럭을 최대 5개까지 표시
		int startPage = (pg-1)/5*5+1;
		int endPage = startPage + 4;
		if(endPage > totalP) 
			endPage = totalP;
		
		// 데이터 공유
		ModelAndView mv = new ModelAndView();
		// leejiwon >>> mv.addObject("mem_id", mem_id);
		mv.addObject("pg", pg);
		// leejiwon >>> mv.addObject("keyword", keyword);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		
		// 화면 네비게이션
		mv.setViewName("/cook/chef.jsp");
		
		return mv;
	}
	*/
}