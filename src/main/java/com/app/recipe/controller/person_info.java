package com.app.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/* signup_page, contact_page, search_password 페이지 */
@Controller
public class person_info {
	
	/* 로그인 지웠음 로그인은 LoginAPI로 이동시킴*/
	
	/* 2020.06.28 index_page() --> MenuController로 이동함 */
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
	
	@RequestMapping(value ="/member/search_password.do", method=RequestMethod.GET)
	public ModelAndView search_password() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/search_password.jsp");
		return mv;
	}
	/* 2020.06.29 profile controller */
	@RequestMapping(value="/member/profile.do", method=RequestMethod.GET)
	public ModelAndView myprofile() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/profile.jsp");
		return mv;
	}
	/* 2020.06.29 recipe_create controller */
	@RequestMapping(value="/recipe/method_create.do", method=RequestMethod.GET)
	public ModelAndView my_method_create() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/recipe/method_create.jsp");
		return mv;
	}
}
