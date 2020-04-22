package com.bridgelabz.fundoonotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(String email, String response) {
        try {
            SimpleMailMessage simpleMailMsg = new SimpleMailMessage();
            simpleMailMsg.setTo(email);
            simpleMailMsg.setSubject("Mail Verification");
            simpleMailMsg.setText(response);
            javaMailSender.send(simpleMailMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
