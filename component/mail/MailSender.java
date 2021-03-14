package component.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import component.parser.InvoiceWrapper;
import component.parser.Item;
import component.parser.ParserHelper;

public class MailSender implements XMLtoEmail {

	@Override
	public void sendEmail(String to, String filename) throws Exception {
		
		InvoiceWrapper data=ParserHelper.getInvoiceData(filename);
		
		final String host = "smtp.gmail.com";
    	final int port = 587;
    	final String username = "kgvicky24@gmail.com";
    	final String password = "lufi2412";
        
        
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
            
            StringBuilder email = new StringBuilder();
            email.append("<html><body>"
                    + "<br><br><table style='border:2px solid black'>");
            email.append("<tr>");
            email.append("<th colspan='3'>Name: ");
            email.append(data.getCustomer().getName()+"</th>");
            email.append("<th>Invoice No: ");
            email.append(data.getCustomer().getBillid()+"</th>");
            email.append("<th>Date: ");
            email.append(data.getCustomer().getBilldate()+"</th>");
            email.append("</tr>");
            
            
            email.append("<tr>");
            email.append("<th>ID</th>");
            email.append("<th>Name</th> ");
            email.append("<th>Unit</th>");
            email.append("<th>Price</th>");
            email.append("<th>Qty</th>");
            email.append("<th>Amount</th>");
            email.append("</tr>");
            
            int total=0;
            
            for(Item item: data.getItems()) {
            	email.append("<tr>");
            	email.append("<td>"+item.getId()+"</td>"
            			+"<td>"+item.getName()+"</td>"+
            			"<td>"+item.getUnit()+"</td>"+
            			"<td>"+item.getPrice()+"</td>"+
            			"<td>"+item.getQty()+"</td>"+
            			"<td>"+item.getAmount()+"</td>");
            	email.append("</tr>");
            	total+=item.getAmount();
            }
            
            email.append("<tr><td colspan='5'>Total Amount</td><td>"+total+"</td></tr></table></body></html>");
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(email.toString(), "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            
            System.out.println("Mail Sent...!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
