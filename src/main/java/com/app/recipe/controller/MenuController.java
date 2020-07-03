package com.app.recipe.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.service.RecipeService;
import com.app.recipe.service.RegisterService;

@Controller
public class MenuController {
	@Inject
	private RegisterService svc;
	@Inject
	private RecipeService rsc;
    
	@RequestMapping(value ="/member/index.do", method=RequestMethod.GET)
	public ModelAndView index_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/index.jsp");
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
	
}
