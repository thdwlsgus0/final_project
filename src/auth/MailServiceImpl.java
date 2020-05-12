package auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service
public class MailServiceImpl implements MailService{
 
	// logging ¼³Á¤
	private Log log = LogFactory.getLog(MailService.class);
	
	@Override
	public boolean send(String subject, String text, String from, String to, String filePath) {
		return false;
	}

}
