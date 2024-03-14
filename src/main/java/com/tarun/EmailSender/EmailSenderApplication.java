package com.tarun.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.tarun.EmailSender.service.HomeService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class EmailSenderApplication {

	@Autowired
	HomeService homeservice;
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		//homeservice.SendSimpleMail("tarunreddytkr11@gmail.com", "test body argument", "subject argument");
		
		homeservice.SendAttachmentMail("tarunreddytkr11@gmail.com", "test body argument", "subject argument", "/Users/tarunreddy/Downloads/TarunReddy_Murakonda.pdf");
		
	}
}
