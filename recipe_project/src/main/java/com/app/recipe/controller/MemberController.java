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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.dao.memberService;
import com.app.recipe.model.RegisterDto;


@Controller // ��Ʈ�ѷ� �� ����
public class MemberController {
    //@Inject // ���񽺸� ȣ���ϱ� ���ؼ� �������� ����
    // ���� �߼� ����� ���� MailSender �������̽� ����
	@Inject
    private JavaMailSender mailSender; // ���� ���񽺸� ����ϱ� ���� �������� ������.
	
	
	memberService memberservice; // ���񽺸� ȣ���ϱ� ���� �������� ����.
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@PostMapping("/email/gauth.do")
	public ModelAndView gmails(@RequestBody RegisterDto dto) {
		System.out.println("dto: " + dto.getEmail());
		return dice(dto.getEmail());
	}
	
	private ModelAndView dice(String email) {
		Random r = new Random();
		int dice = r.nextInt(4589362)+49311; // 49311 ~ 49311 + 4589362
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth.jsp");
		mv.addObject("dice", dice);
		
		sendEmail(email, dice);
		
		return mv;
	}
	
	@RequestMapping(value ="/email/auth.do", method=RequestMethod.POST)
	// ModelAndView�� �����͸� �������ִ� Ÿ��
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException{
		// ������ �̸��� �ּ�
		String tomail = request.getParameter("e_mail");
		return dice(tomail);
	}
	
	public void sendEmail(String email, int dice) {
		String host = "smtp.naver.com";
		String subject = "�޴����� ������ȣ ����";
		String fromName = "�޴����� ������";
		String from="thdwlsgus0@naver.com"; //�ϴ� ���̹��� �Ͽ����ϴ�.
		String content = "������ȣ["+dice+"]";
		System.out.println(email + " : "+dice);
		try {
			MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");
            messageHelper.setFrom(from); // �����»�� �����ϸ� �����۵��� ����
            messageHelper.setTo(email); // �޴»�� �̸���
            messageHelper.setSubject(subject); // ���������� ������ �����ϴ�
            messageHelper.setText(content); // ���� ����
            mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/email/join_injeung.do", method = RequestMethod.POST)
	public ModelAndView join_injeung(HttpServletRequest request,String email_injeung,  HttpServletResponse response_equals) throws IOException{
		String dice = request.getParameter("dice");
		System.out.println("������ : email_injeung : "+email_injeung);
		System.out.println("������ : dice : "+dice);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/email/email_auth.jsp");
		mv.addObject("e_mail",email_injeung);
		if(email_injeung.equals(dice)) { // ������ȣ�� ���� ��� ������ȣ�� ��ġ�Ͽ����Ƿ� ȸ������â���� �ٽ� �̵���Ŵ
			mv.setViewName("/member/login.jsp");
			mv.addObject("e_mail", email_injeung);
		    response_equals.setContentType("text/html; charset=UTF-8");
		    PrintWriter out_equals = response_equals.getWriter();
		    out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. ȸ������â���� �̵��մϴ�.');</script>");
		    out_equals.flush();
		    return mv;
		}else if(email_injeung != dice) {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("/email/email_auth.jsp");
			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
			out_equals.flush();
			return mv2;
		}
		return mv;
	} 
}