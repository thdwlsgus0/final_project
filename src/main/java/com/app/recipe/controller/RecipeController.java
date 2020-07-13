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
	
	@Inject
	private RecipeService rsc;

	private HashMap<String, Integer> get_page(String str_pg, String mem_id, String keyword, String options) {
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
		
		int endNum = pg * 20;
		hm.put("endNum", endNum);
		int startNum = endNum - 19;
		hm.put("startNum", startNum);

		int totalA = rsc.getTotalArticle(mem_id, keyword, options);
		hm.put("totalA", totalA);
		int totalP = (totalA + (20 - 1)) / 20; // 'total Page' : 총 페이지 수
		hm.put("totalP", totalP);

		int startPage = (pg - 1) / 5 * 5 + 1;
		hm.put("startPage", startPage);
		int endPage = startPage + 4;
		if (endPage > totalP)
			endPage = totalP;
		hm.put("endPage", endPage);
		return hm;
	}

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
		int totalA = page_hash.get("totalA");
		int totalP = page_hash.get("totalP");
		int startPage = page_hash.get("startPage");
		int endPage = page_hash.get("endPage");
		int pg = page_hash.get("pg");
		
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum, mem_id, keyword, options);

		ModelAndView mv = new ModelAndView();
		mv.addObject("mem_id", mem_id);
		mv.addObject("pg", pg);
		mv.addObject("keyword", keyword);
		mv.addObject("list", list);
		mv.addObject("totalA", totalA);
		mv.addObject("totalP", totalP);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);

		mv.setViewName("/cook/chef");
		return mv;
	}

	@RequestMapping(value = "/recipe/method.do", method = RequestMethod.GET)
	public ModelAndView method_page(HttpServletRequest request,
									@RequestParam(defaultValue = "") String mem_id,
									@RequestParam(defaultValue = "") String food,
									@RequestParam(defaultValue = "all") String options) {

		String food_name = request.getParameter("food");
		String str_pg = request.getParameter("pg");

		int food_cnt = 0;
		HashMap<String, Integer> page_hash = new HashMap<>();
		page_hash = get_page(str_pg, mem_id, food_name, options);

		food_cnt = page_hash.get("totalA");
		int startNum = page_hash.get("startNum");
		int endNum = page_hash.get("endNum");
		int totalP = page_hash.get("totalP");
		int startPage = page_hash.get("startPage");
		int endPage = page_hash.get("endPage");
		int pg = page_hash.get("pg");
		
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum, mem_id, food_name, options);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("food_cnt", food_cnt);
		mv.addObject("food_name", food_name);
		mv.addObject("pg", pg);
		mv.addObject("optionKeyword", food_name);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		mv.addObject("options", options);

		mv.setViewName("/recipe/method");
		return mv;
	}
	
}