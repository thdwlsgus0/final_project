package auth;

public interface MailService {
 
    public boolean send(String subject, String text, String from, String to, String filePath);
}