package com.app.recipe.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.model.RegisterDto;
import com.app.recipe.util.member.RegistUtil;


@Controller
public class MemberController {
	@Inject
    private JavaMailSender mailSender;
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@PostMapping("/email/gauth")
	public ModelAndView gmails(@RequestBody RegisterDto dto) {
		return sendcommand(dto);
	}
	
	private ModelAndView sendcommand(RegisterDto dto) {
		int dice = Integer.parseInt(dto.getCheck());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth2");
		mv.addObject("dice", dice);
		
		String id = dto.getId() == null ? dto.getEmail() : dto.getId();
		RegistUtil.sendEmail(mailSender, dto.getEmail(), id, dto.getAuth(), dice);
		
		return mv;
	}
	
	@RequestMapping(value ="/email/auth", method=RequestMethod.POST)
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException{
		String tomail = request.getParameter("e_mail");
		RegisterDto dto = new RegisterDto(tomail);
		dto.setCheck(request.getParameter("dice"));
		return sendcommand(dto);
	}
}
