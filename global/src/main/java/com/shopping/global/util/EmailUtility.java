package com.shopping.global.util;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;
@Component
public class EmailUtility {
	
   public void sendMails(String toId,String fromId,final String userName,final String password,String subject) {
      // Recipient's email ID needs to be mentioned.
     // String to = "ramohanca@gmail.com";

      // Sender's email ID needs to be mentioned
      //String from = "namadipta.patro@gmail.com";

       //username = "namadipta.patro@gmail.com";//change accordingly
       //password = "Apple@2015";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
  //    String host = "relay.jangosmtp.net";

      Properties props = new Properties();
      props.put("mail.smtp.user","userName"); 
      props.put("mail.smtp.host", "smtp.gmail.com"); 
      props.put("mail.smtp.port", "25"); 
      props.put("mail.debug", "true"); 
      props.put("mail.smtp.auth", "true"); 
      props.put("mail.smtp.starttls.enable","true"); 
      props.put("mail.smtp.EnableSSL.enable","true");

      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
      props.setProperty("mail.smtp.socketFactory.fallback", "false");   
      props.setProperty("mail.smtp.port", "465");   
      props.setProperty("mail.smtp.socketFactory.port", "465"); 
      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(userName, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(fromId));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(toId));

         // Set Subject: header field
         message.setSubject("Password Reset BGS system");

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(subject);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
//         messageBodyPart = new MimeBodyPart();
//         String filename = "C:\\test.txt";
//         DataSource source = new FileDataSource(filename);
//         messageBodyPart.setDataHandler(new DataHandler(source));
//         messageBodyPart.setFileName(filename);
//         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}
