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

@Controller // ��Ʈ�ѷ� �� ����
public class MemberController {
    @Inject // ���񽺸� ȣ���ϱ� ���ؼ� �������� ����
    // ���� �߼� ����� ���� MailSender �������̽� ����
    private JavaMailSender mailSender; // ���� ���񽺸� ����ϱ� ���� �������� ������.
	MemberService memberservice; // ���񽺸� ȣ���ϱ� ���� �������� ����.
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@RequestMapping(value ="/member/auth.do", method=RequestMethod.POST)
	// ModelAndView�� �����͸� �������ִ� Ÿ��
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException{
		Random r = new Random();
		int dice = r.nextInt(4589362)+49311;
		// ������ �̸��� �ּ�
		String setfrom = "thdwlsgus0@naver.com"; 
		String tomail = request.getParameter("email");
		String title = "ȸ������ ���� �̸����Դϴ�.";
		String content =
		// System.getProperty�� ���α׷��� �ۼ��ϴ� ���� �ü��(OS)�� JVM�� �������� ������ �˾ƾ� �� �� �����.
		// �� ��, System.getPropert(key)�޼ҵ带 �̿��Ͽ� ���� ������ �� �� �ִµ� key �κп� �˰����ϴ� Ű���� ������ Ű�� �ش��ϴ� ������ �˷��ݴϴ�. 
	    System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
	    System.getProperty("line.separator")+
	    "�ȳ��ϼ��� ȸ���� ���� Ȩ�������� ã�ƿ��ּż� �����մϴ�."
	    +System.getProperty("line.separator")+
	    System.getProperty("line.separator")+
	    " ������ȣ�� "+dice+" �Դϴ�. "
	    +System.getProperty("line.separator")+
	    System.getProperty("line.separator")+
	    "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�."; // ����
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		    messageHelper.setFrom(setfrom);  // ������ ��� �����ϸ� �����۵��� ����
		    messageHelper.setTo(tomail); // �޴»�� �̸���
		    messageHelper.setSubject(title); // ���������� ������ ������
		    messageHelper.setText(content); // ���� ����
		    
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
		out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
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
