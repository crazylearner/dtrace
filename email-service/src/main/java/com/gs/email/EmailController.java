package com.gs.email;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by schellamuthu on 12/10/18.
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;

    @PostMapping("/send")
    public Response sendEmail(@RequestBody EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());
        emailSender.send(message);
        return new Response();
    }

    @Data
    public static class EmailRequest {
        String to;
        String subject;
        String text;
    }

    @Data
    public class Response {
        String status = "ok";
    }
}
