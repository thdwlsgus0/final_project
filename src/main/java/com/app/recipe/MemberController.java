package com.app.recipe;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.service.member.MemberService;

@Controller // 컨트롤러 빈 선언
public class MemberController {
    @Inject // 서비스를 호출하기 위해서 의존성을 주입
    // 메일 발송 기능을 위한 MailSender 인터페이스 제공
    private JavaMailSender mailSender; // 메일 서비스를 사용하기 위해 의존성을 주입함.
	MemberService memberservice; // 서비스를 호출하기 위해 의존성을 주입.
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@RequestMapping(value ="/member/auth.do", method=RequestMethod.POST)
	// ModelAndView는 데이터를 전송해주는 타입
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException{
		Random r = new Random();
		int dice = r.nextInt(4589362)+49311;
		// 보내는 이메일 주소
		String setfrom = "thdwlsgus0@naver.com"; 
		String tomail = request.getParameter("email");
		String title = "회원가입 인증 이메일입니다.";
		String content =
		// System.getProperty는 프로그램을 작성하다 보면 운영체제(OS)나 JVM에 의존적인 정보를 알아야 할 때 사용함.
		// 이 때, System.getPropert(key)메소드를 이용하여 각종 정보를 알 수 있는데 key 부분에 알고자하는 키값을 넣으면 키에 해당하는 정보를 알려줍니다. 
	    System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
	    System.getProperty("line.separator")+
	    "안녕하세요 회원님 저희 홈페이지를 찾아와주셔서 감사합니다."
	    +System.getProperty("line.separator")+
	    System.getProperty("line.separator")+
	    " 인증번호는 "+dice+" 입니다. "
	    +System.getProperty("line.separator")+
	    System.getProperty("line.separator")+
	    "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		    messageHelper.setFrom(setfrom);  // 보내는 사람 생략하면 정상작동을 안함
		    messageHelper.setTo(tomail); // 받는사람 이메일
		    messageHelper.setSubject(title); // 메일제목은 생략이 가능함
		    messageHelper.setText(content); // 메일 내용
		    
		    mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth");
		mv.addObject("dice", dice);
		
		System.out.println("mv : "+mv);
		
		response_email.setContentType("text/html; charset=UTF-8");
		PrintWriter out_email = response_email.getWriter();
		out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력햇주세요.');</script>");
		out_email.flush();
		
		return mv;
	}
	@RequestMapping("/email/email.do")
	public String email() {
		return "email/email";
	}
	
	@RequestMapping(value = "/email/email_auth.do {dice}", method = RequestMethod.POST)
	public ModelAndView join_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals) throws IOException{
		
	}
}
