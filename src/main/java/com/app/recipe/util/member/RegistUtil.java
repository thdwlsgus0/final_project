package com.app.recipe.util.member;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class RegistUtil {
	public static void sendEmail(JavaMailSender mailSender, String email, String id, String auth, int dice) {
		String subject = "[Git들인레시피] 이메일 인증";
		String from = "thdwlsgus0@naver.com";
		String content = "%s님 맞으신가요?\n아래 링크를 통해 회원가입을 마무리할 수 있습니다!\n링크: http://ec2-3-34-77-222.ap-northeast-2.compute.amazonaws.com/member/emailcheck?id=%s&email=%s&dice=%d&auth=%s";
		String rcontent = String.format(content, id, id, email, dice, auth);
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
	}
	
	public static int randomint() {
		Random r = new Random();
		int dice = r.nextInt(4589362)+49311;
		return dice;
	}
}
