package com.app.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class person_info {
	@RequestMapping(value ="/loginForm.do", method=RequestMethod.GET)
	public ModelAndView login_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login.jsp");
		return mv;
	}
	@RequestMapping(value ="/member/signup.do", method=RequestMethod.GET)
	public ModelAndView signup_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/signup.jsp");
		return mv;
	}
	@RequestMapping(value ="/member/contact.do", method=RequestMethod.GET)
	public ModelAndView contact_page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/contact.jsp");
		return mv;
	}
}
