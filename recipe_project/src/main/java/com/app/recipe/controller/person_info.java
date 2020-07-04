package com.app.recipe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.naverLogin.service.NaverLoginBO;

//@Controller
public class person_info {
	
	/* �α��� ������ �α����� LoginAPI�� �̵���Ŵ*/
	
	/* 2020.06.28 index_page() --> MenuController�� �̵��� */
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
}
