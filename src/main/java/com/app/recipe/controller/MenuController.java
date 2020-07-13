package com.app.recipe.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.service.RecipeService;
import com.app.recipe.service.RegisterService;

import com.app.recipe.model.RecipeDTO;
import com.app.recipe.model.RecipeVO;

@Controller
public class MenuController {
	@Inject
	private RegisterService svc;
	@Inject
	private RecipeService rsc;
    
	@RequestMapping(value ="/member/index.do", method=RequestMethod.GET)
	public ModelAndView index_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/index");
		return mv;
	}
	
	@GetMapping(value="/template/footer.do")
	public HashMap<String, Object> footer_data(HttpServletRequest request,
											@RequestParam(defaultValue = "") String mem_id,
											@RequestParam(defaultValue = "") String keyword,
											@RequestParam(defaultValue = "") String options) {
		HashMap<String, Object> hm = new HashMap<>();
		HttpSession session = request.getSession();
		int chef_cnt = svc.chef_select();
		int recipe_cnt = rsc.getTotalArticle(mem_id, keyword, options);
		int total_recipe_cnt = rsc.recipe_total_select();
		session.setAttribute("chef_cnt", chef_cnt);
		session.setAttribute("recipe_cnt", recipe_cnt);
		session.setAttribute("total_recipe_cnt", total_recipe_cnt);
		hm.put("chef_cnt", chef_cnt);
		hm.put("recipe_cnt", recipe_cnt);
		hm.put("total_recipe_cnt", total_recipe_cnt);
        return hm;
	}
	
	@RequestMapping(value ="/cook/chefList.do", method=RequestMethod.GET)
	public ModelAndView chef_page(HttpServletRequest request,
								@RequestParam(defaultValue = "") String mem_id,
								@RequestParam(defaultValue = "") String keyword,
								@RequestParam(defaultValue = "") String options) {
		String str_pg = request.getParameter("pg");
		int pg = 1;
		
		if(str_pg != null) {
			if(str_pg != "") {
				if(str_pg.matches("^[0-9]*$")) {
					pg = Integer.parseInt(str_pg);
				}
			}
		}
		
		int endNum = pg * 20;
		int startNum = endNum - 19;
		
		List<RecipeVO> getChefListMap = rsc.getChefListMap();
		request.setAttribute("list", getChefListMap);

		int totalA = rsc.getTotalArticle(mem_id, keyword, options);
		int totalP = (totalA+(20-1))/20;	// 'total Page' : 총 페이지 수
		
		int startPage = (pg-1)/5*5+1;
		int endPage = startPage + 4;
		if(endPage > totalP) 
			endPage = totalP;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pg", pg);
		mv.addObject("mem_id", mem_id);
		
		mv.addObject("totalP", totalP);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		
		mv.setViewName("/cook/chefList");
		
		return mv;
	}
	

	@RequestMapping(value ="/cook/chefRecent.do", method=RequestMethod.GET)
	public ModelAndView chefRecent_page(HttpServletRequest request,
								@RequestParam(defaultValue = "") String mem_id,
								@RequestParam(defaultValue = "") String keyword) {
		String str_pg = request.getParameter("pg");
		int pg = 1;
		
		if(str_pg != null) {
			if(str_pg != "") {
				if(str_pg.matches("^[0-9]*$")) {
					pg = Integer.parseInt(str_pg);
				}
			}
		}
		
		int endNum = pg * 20;
		int startNum = endNum - 19;
		
		List<RecipeVO> getRecentListMap = rsc.getRecentListMap();
		request.setAttribute("list", getRecentListMap);

		ModelAndView mv = new ModelAndView();
		mv.addObject("pg", pg);
		mv.addObject("mem_id", mem_id);
		
		mv.setViewName("/cook/chefRecent");
		
		return mv;	
	}
	@RequestMapping(value ="/cook/chefRank.do", method=RequestMethod.GET)
	public ModelAndView chefRank_page(HttpServletRequest request,
								@RequestParam(defaultValue = "") String mem_id,
								@RequestParam(defaultValue = "") String keyword) {
		String str_pg = request.getParameter("pg");
		int pg = 1;
		
		if(str_pg != null) {
			if(str_pg != "") {
				if(str_pg.matches("^[0-9]*$")) {
					pg = Integer.parseInt(str_pg);
				}
			}
		}
		
		int endNum = pg * 20;
		int startNum = endNum - 19;
		
		List<RecipeVO> getRecentSign = rsc.getRecentSign();
		request.setAttribute("list", getRecentSign);

		ModelAndView mv = new ModelAndView();
		mv.addObject("pg", pg);
		mv.addObject("mem_id", mem_id);
		
		mv.setViewName("/cook/chefRank");
		
		return mv;	
	}
}