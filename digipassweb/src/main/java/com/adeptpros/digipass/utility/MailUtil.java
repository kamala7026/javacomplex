package com.adeptpros.digipass.utility;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	public static boolean  sendMail(String receiver,String message,String subject) throws Exception {
    	final String username = "kamalakanta.b@adeptpros.com";
        final String password = "kamala#123";
        boolean status=false;
    	Properties properties = new Properties();
    	properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.starttls.enable", "true");
    	properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    	properties.put("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.port", "587");
    	properties.put("mail.debug", "true");
    	
    	/*Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
    	    protected PasswordAuthentication getPasswordAuthentication() {
    	        return new PasswordAuthentication(username, password);
    	    }
    	});*/
    	
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(username));
        InternetAddress[] toAddresses = { new InternetAddress(receiver) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setContent(message, "text/html");
 
        try{
        	Transport.send(msg);
        	status=true;
        }catch(Exception e){
        	status=false;
        	throw e;
        }
        return status;
    }
	public static void main(String[] args) {
		try {
			System.out.println(MailUtil.sendMail("kamalakanta.b@adeptpros.com", "<h1>This is actual message</h1>","Trail mail"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
