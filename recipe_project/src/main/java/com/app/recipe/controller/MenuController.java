package com.app.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.dao.RecipeService;
import com.app.recipe.model.RecipeDTO;

@Controller
public class MenuController {
	
	@RequestMapping(value ="/member/index.do", method=RequestMethod.GET)
	public ModelAndView index_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/index.jsp");
		return mv;
	}
	@RequestMapping(value ="/recipe/method.do", method=RequestMethod.GET)
	public ModelAndView method_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/recipe/method.jsp");
		return mv;
	}
	
	@RequestMapping(value ="/cook/chefList.do", method=RequestMethod.GET)
	public ModelAndView chef_page(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cook/chefList.jsp");
		return mv;
	}
	
}
