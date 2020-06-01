package com.app.recipe.controller;
 
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.personal.kakaoLogin.service.KakaoAPI;
 
@Controller
public class LoginAPIController {
	
	@Autowired
	private KakaoAPI kakao;
	
    @RequestMapping(value="/login.do",produces="application/json",method=RequestMethod.GET)
    public String login(@RequestParam("code") String code,RedirectAttributes ra,HttpSession session,HttpServletResponse response)throws IOException {
        String access_Token = kakao.getAccessToken(code);
        System.out.println("code : " + code);
        return "login";
    }
}
