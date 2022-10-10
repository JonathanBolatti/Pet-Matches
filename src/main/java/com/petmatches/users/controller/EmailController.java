package com.petmatches.users.controller;


import com.petmatches.users.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class EmailController {

    @Autowired
    EmailService emailService;


    @RequestMapping(value = "/send-mail", method = RequestMethod.GET)
    public ResponseEntity<?> sendMail(){
    emailService.sendMail();
    return new ResponseEntity<>("Correo enviado con exito, revise su email", HttpStatus.OK);
    }

}
