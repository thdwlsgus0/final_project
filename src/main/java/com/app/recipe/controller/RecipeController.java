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

import com.app.recipe.model.RecipeDTO;
import com.app.recipe.service.RecipeService;

@Controller
public class RecipeController {

	@Inject
	private RecipeService rsc;

	private HashMap<String, Integer> get_page(String str_pg, String keyword) {
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
		int totalA = rsc.getTotalArticle(keyword);
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

	@RequestMapping(value = "/cook/chef.do", method = RequestMethod.GET)
	public ModelAndView getRecipeList(HttpServletRequest request, @RequestParam(defaultValue = "") String keyword) {
		String mem_id = "이지원";
		// String mem_id = request.getParameter("mem_id");
		String str_pg = request.getParameter("pg");

		HashMap<String, Integer> page_hash = new HashMap<>();
		page_hash = get_page(str_pg, keyword);

		int startNum = page_hash.get("startNum");
		int endNum = page_hash.get("endNum");
		int totalP = page_hash.get("totalP");
		int startPage = page_hash.get("startPage");
		int endPage = page_hash.get("endPage");
		int pg = page_hash.get("pg");
		// RecipeDAOImpl recipeDAOImpl = new RecipeDAOImpl();
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum, mem_id, keyword);

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
	@RequestMapping(value = "/recipe/method.do", method = RequestMethod.GET)
	public ModelAndView method_page(HttpServletRequest request) {

		String food_name = request.getParameter("food");
		String str_pg = request.getParameter("pg");
		HashMap<String, Integer> page_hash = new HashMap<>();
		page_hash = get_page(str_pg, food_name);
		int startNum = page_hash.get("startNum");
		int endNum = page_hash.get("endNum");
		int totalP = page_hash.get("totalP");
		int startPage = page_hash.get("startPage");
		int endPage = page_hash.get("endPage");
		int pg = page_hash.get("pg");
		List<RecipeDTO> list = null;
		ModelAndView mv = new ModelAndView();
		int food_cnt = 0;
		if(food_name==null) {
			food_cnt = rsc.recipe_select();
			list = rsc.getAllList(startNum, endNum);
		}
	    else {
			list = rsc.getKeywordList(startNum, endNum, food_name);
			food_cnt = rsc.recipe_food_result(food_name);
		}

		mv.addObject("food_cnt", food_cnt);
		mv.addObject("food_name", food_name);
		mv.addObject("pg", pg);
		mv.addObject("keyword", food_name);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP); // 총 페이지 수
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage); // 총 게시물 수에 의한 마지막 페이지 수

		mv.setViewName("/recipe/method.jsp");
		return mv;
	}
}
