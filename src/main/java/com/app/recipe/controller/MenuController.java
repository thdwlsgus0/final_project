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
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.service.RecipeService;
import com.app.recipe.service.RegisterService;

import com.app.recipe.model.RecipeDTO;

@Controller
public class MenuController {
	
// >>>>> merge
	
	@Inject
	private RegisterService svc;
	@Inject
	private RecipeService rsc;
    
	@RequestMapping(value ="/", method=RequestMethod.GET)
	public ModelAndView index_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/index");
		return mv;
	}
	
	@GetMapping(value="/template/footer.do")
	public HashMap<String, Object> footer_data(HttpServletRequest request){
		HashMap<String, Object> hm = new HashMap<>();
		HttpSession session = request.getSession();
		int chef_cnt = svc.chef_select();
		int recipe_cnt = rsc.recipe_select();
		int total_recipe_cnt = rsc.recipe_total_select();
		session.setAttribute("chef_cnt", chef_cnt);
		session.setAttribute("recipe_cnt", recipe_cnt);
		session.setAttribute("total_recipe_cnt", total_recipe_cnt);
		hm.put("chef_cnt", chef_cnt);
		hm.put("recipe_cnt", recipe_cnt);
		hm.put("total_recipe_cnt", total_recipe_cnt);
        return hm;
	}
	
// >>>>> limsh
	
	@RequestMapping(value ="/cook/chefList.do", method=RequestMethod.GET)
	public ModelAndView chef_page(HttpServletRequest request) {
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
		
		// RecipeDAOImpl recipeDAOImpl = new RecipeDAOImpl();
		List<RecipeDTO> list = rsc.getRecipeList(startNum, endNum);
		
		// 페이징 처리
		int totalA = rsc.getTotalArticle();
		int totalP = (totalA+(20-1))/20;	// 'total Page' : 총 페이지 수
		
		//mem_id
		String mem_id = "";
		
		// 페이지 블럭을 최대 5개까지 표시
		int startPage = (pg-1)/5*5+1;
		int endPage = startPage + 4;
		if(endPage > totalP) 
			endPage = totalP;
		
		//레시피 카운트
		int getRecipeCount = rsc.getRecipeCount(mem_id);
		
		// 데이터 공유
		ModelAndView mv = new ModelAndView();
		mv.addObject("pg", pg);
		mv.addObject("mem_id", mem_id);
		mv.addObject("list", list);
		mv.addObject("totalP", totalP);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		
		mv.addObject("getRecipeCount",getRecipeCount);
		System.out.println("getRecipeCount " + getRecipeCount);
		
		// 화면 네비게이션
		mv.setViewName("/cook/chefList");
		
		return mv;
		
	}
}