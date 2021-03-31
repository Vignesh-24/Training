package utility.mail;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class MailSender implements XMLtoEmail {

	@Override
	public void sendEmail(String to, String filename) throws Exception {
		
		
		
		final String host = "smtp.gmail.com";
    	final int port = 587;
    	final String username = "kgvicky24@gmail.com";
    	final String password = "urpass";
        
        
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
		
        
        try {
        	
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Invoice Details");
            
            
            BodyPart messageBodyPart = new MimeBodyPart(); 
    		messageBodyPart.setText("Hello User..."+"\n"+"Here is your invoice!!");
    		MimeBodyPart attachmentPart = new MimeBodyPart();
    		attachmentPart.attachFile(new File(filename));
    		Multipart multipart = new MimeMultipart();
    		multipart.addBodyPart(messageBodyPart);
    		multipart.addBodyPart(attachmentPart);
    		message.setContent(multipart);
    		Transport.send(message);		
    		
    		System.out.println("Email Sucessfully Sent");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
