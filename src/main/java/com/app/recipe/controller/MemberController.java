package com.app.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.memberService;


@Controller // 컨트롤러 빈 선언
public class MemberController {
    //@Inject // 서비스를 호출하기 위해서 의존성을 주입
    // 메일 발송 기능을 위한 MailSender 인터페이스 제공
	@Inject
    private JavaMailSender mailSender; // 메일 서비스를 사용하기 위해 의존성을 주입함.
	
	
	memberService memberservice; // 서비스를 호출하기 위해 의존성을 주입.
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@PostMapping("/email/gauth.do")
	public ModelAndView gmails(@RequestBody RegisterDto dto) {
		System.out.println("dto: " + dto.getEmail());
		return dice(dto);
	}
	
	private ModelAndView dice(RegisterDto dto) {
		Random r = new Random();
		int dice = r.nextInt(4589362)+49311; // 49311 ~ 49311 + 4589362
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth2.jsp");
		mv.addObject("dice", dice);
		
		String id = dto.getId() == null ? dto.getEmail() : dto.getId();
		sendEmail(dto.getEmail(), id, dice);
		
		return mv;
	}
	
	@RequestMapping(value ="/email/auth.do", method=RequestMethod.POST)
	// ModelAndView는 데이터를 전송해주는 타입
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException{
		// 보내는 이메일 주소
		String tomail = request.getParameter("e_mail");
		return dice(new RegisterDto(tomail));
	}
	
	public int sendEmail(String email, String id, int dice) {
		String host = "smtp.naver.com";
		String subject = "달달하조 인증번호 전달";
		String fromName = "달달하조 관리자";
		String from="thdwlsgus0@naver.com"; //일단 네이버로 하였습니다.
		String content = "링크: http://localhost:8090/recipe/member/emailcheck.do?id=%s&dice=%d";//"인증번호["+dice+"]";
		String rcontent = String.format(content, id, dice);
		try {
			MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setFrom(from); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(email); // 받는사람 이메일
            messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
            messageHelper.setText(rcontent); // 메일 내용
            mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dice;
	}
	
	@RequestMapping(value = "/email/join_injeung.do", method = RequestMethod.POST)
	public ModelAndView join_injeung(HttpServletRequest request,String email_injeung,  HttpServletResponse response_equals) throws IOException{
		String dice = request.getParameter("dice");
		System.out.println("마지막 : email_injeung : "+email_injeung);
		System.out.println("마지막 : dice : "+dice);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth.jsp");
		mv.addObject("e_mail",email_injeung);
		if(email_injeung.equals(dice)) { // 인증번호가 같은 경우 인증번호가 일치하였으므로 회원가입창으로 다시 이동시킴
			mv.setViewName("/member/login.jsp");
			mv.addObject("e_mail", email_injeung);
		    response_equals.setContentType("text/html; charset=UTF-8");
		    PrintWriter out_equals = response_equals.getWriter();
		    out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.');</script>");
		    out_equals.flush();
		    return mv;
		}else if(email_injeung != dice) {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("/email/email_auth.jsp");
			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
			out_equals.flush();
			return mv2;
		}
		return mv;
	} 
}
