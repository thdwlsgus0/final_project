package auth.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	// logging ¼³Á¤
	private Log log = LogFactory.getLog(MailService.class);
	// org.springframework.mail.javamail.JavaMailSender
	@Autowired
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender )

	@Override
	public boolean send(String subject, String text, String from, String to, String filePath) {
		return false;
	}

}
