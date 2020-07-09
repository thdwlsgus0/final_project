package com.app.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.model.RegisterDto;


@Controller
public class MemberController {
	@Inject
    private JavaMailSender mailSender;
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@PostMapping("/email/gauth.do")
	public ModelAndView gmails(@RequestBody RegisterDto dto) {
		System.out.println("dto: " + dto.getEmail());
		return dice(dto);
	}
	
	private ModelAndView dice(RegisterDto dto) {
		Random r = new Random();
		int dice = r.nextInt(4589362)+49311; // 49311 ~ 49311 + 4589362
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth2");
		mv.addObject("dice", dice);
		
		String id = dto.getId() == null ? dto.getEmail() : dto.getId();
		sendEmail(dto.getEmail(), id, dice);
		
		return mv;
	}
	
	@RequestMapping(value ="/email/auth.do", method=RequestMethod.POST)
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException{
		String tomail = request.getParameter("e_mail");
		return dice(new RegisterDto(tomail));
	}
	
	public int sendEmail(String email, String id, int dice) {
		String subject = "달달하조 이메일 인증";
		String from="thdwlsgus0@naver.com";
		String content = "링크: http://ec2-3-34-77-222.ap-northeast-2.compute.amazonaws.com/member/emailcheck.do?id=%s&dice=%d";//"������ȣ["+dice+"]";
		String rcontent = String.format(content, id, dice);
		try {
			MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setFrom(from);
            messageHelper.setTo(email);
            messageHelper.setSubject(subject);
            messageHelper.setText(rcontent);
            mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return dice;
	}
}
