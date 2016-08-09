package com.sendEmail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SimpleEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String fromEmail = "**********@gmail.com";//please provide actual sender's email
		final String password = "********";// please provide actual password
		final String toEmail = "************@gmail.com";//please provide actual receiver's email.
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(fromEmail,password);
			}
		};
		
		Session session = Session.getInstance(props,auth);
		EmailUtil.sendEmail(session, toEmail, "Email Testing by Thousif", "Hi I am testing my new program using Java");
	}

}
