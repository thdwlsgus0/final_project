package com.app.recipe.controller;

import javax.inject.Inject;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		int dice = RegistUtil.randomint();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth2");
		mv.addObject("dice", dice);
		
		String id = dto.getId() == null ? dto.getEmail() : dto.getId();
		RegistUtil.sendEmail(mailSender, dto.getEmail(), id, dto.getAuth(), dice);
		return mv;
	}
	
}
