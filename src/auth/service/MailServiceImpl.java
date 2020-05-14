package auth.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	// logging 설정
	private Log log = LogFactory.getLog(MailService.class);
	// org.springframework.mail.javamail.JavaMailSender
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	@Override
	public boolean send(String subject, String text, String from, String to) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			// MimeMessage 객체를 직접 생성하여 메일을 발송하는 것도 가능하지만 MimeMessageHelper를 사용하는 것이 가장 간단한 방법
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		    helper.setSubject(subject);
		    helper.setText(text, true);
		    helper.setFrom(from);
		    helper.setTo(to);
		    
		    javaMailSender.send(message);
		    return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

}
