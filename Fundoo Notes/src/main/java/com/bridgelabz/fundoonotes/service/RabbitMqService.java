package com.bridgelabz.fundoonotes.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService {
    @Autowired
    private MailService mailService;

    @RabbitListener(queues="${spring.rabbitmq.user.queue}")
    public void recieveUserMail(SimpleMailMessage mail) {
        mailService.sendEmail(mail);
    }
}
