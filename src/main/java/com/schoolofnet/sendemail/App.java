package com.schoolofnet.sendemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	Properties properties = System.getProperties();
    	
    	properties.setProperty("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.starttls.enable", "true");
    	properties.put("mail.smtp.auth", "true");
    	
    	Session session = Session.getDefaultInstance(properties, new Authenticator() {
    		@Override
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication("#####@gmail.com", "##########");
    		}
		});
    	
    	try {
    		MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("#####@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("l.felipe.hora@gmail.com"));
			message.setSubject("Schoolofnet - Direto ao ponto - Envio de e-mails com Java");
			message.setText("Testinho envio de e-mails com Java");
			
			Transport.send(message);
			System.out.println("E-mail send...");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    	
    	System.exit(0);
    }
}
