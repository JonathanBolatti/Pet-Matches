package com.petmatches.users.service.impl;

import com.petmatches.users.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service("emailService")
public class EmailServiceImpl implements EmailService {


    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("jonathanbolatti@gmail.com");
        simpleMailMessage.setTo("jonathanbolatti@gmail.com");
        simpleMailMessage.setSubject("Prueba de servicio de envio de correos");
        simpleMailMessage.setText("este es el contendi del mail");

        javaMailSender.send(simpleMailMessage);
    }
}
