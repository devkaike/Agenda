package com.kaike.filesAgenda.email.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaike.filesAgenda.email.domain.Email;
import com.kaike.filesAgenda.email.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void sendEmail(@RequestBody Email email) {
        emailService.sendEmail(email);
    }
}
