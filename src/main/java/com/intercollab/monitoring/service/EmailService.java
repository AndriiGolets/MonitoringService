package com.intercollab.monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by andrii on 12/19/17.
 */

@Component
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage( String subject, String text, String to) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("registration@proissue.com");
        emailSender.send(message);
    }

    public void sendMessages(String subject, String text, String... emailList){
        Arrays.asList(emailList).forEach(email -> sendSimpleMessage(subject, text, email));
    }

}
