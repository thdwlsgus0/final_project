package com.app.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavController {
	@RequestMapping(value ="/member/signup", method=RequestMethod.GET)
	public ModelAndView signup_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value ="/member/contact", method=RequestMethod.GET)
	public ModelAndView contact_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/contact");
		return mv;
	}
	
	@RequestMapping(value ="/member/search_password", method=RequestMethod.GET)
	public ModelAndView search_password() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/search_password");
		return mv;
	}
}
