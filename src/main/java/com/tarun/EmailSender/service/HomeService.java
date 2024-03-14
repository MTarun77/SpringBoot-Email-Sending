package com.tarun.EmailSender.service;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class HomeService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void SendSimpleMail(String toMail,String body,String subject) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("tarunreddytkr11@gmail.com");
		msg.setTo(toMail);
		msg.setText(body);
		msg.setSubject(subject);
		
		javaMailSender.send(msg);
		
		System.out.println("test email sent to:" +toMail );
		
	}
	
	public void SendAttachmentMail(String toMail,String body, String subject, String attachment)
	throws MessagingException{
	{
		
		MimeMessage mimeMessage= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
		
		mimeMessageHelper.setFrom("tarunreddytkr11@gmail.com");
		mimeMessageHelper.setTo(toMail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystem=new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
		javaMailSender.send(mimeMessage);
		
		System.out.println("test email sent to:" +toMail ); 
		
	}
	}
}
