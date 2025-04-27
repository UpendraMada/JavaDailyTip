package com.upendra.java_daily_tip.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


     @Autowired
     private JavaMailSender mailSender;

     public void sendEmail(String to, String subject, String message) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);                  // Receiver's email
            mailMessage.setSubject(subject);         // Email subject
            mailMessage.setText(message);            // Email body
            mailMessage.setFrom("");

            mailSender.send(mailMessage);            // Send the email
            System.out.println("Email sent successfully to: " + to);
        }
    }


