package com.upendra.java_daily_tip.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
    public class ScheduledEmailService {

        @Autowired
        private EmailService emailService;

        @Autowired
        private ChatGPTService chatGPTService;

        @Scheduled(cron = "0 0 9 * * ?")  // Runs daily at 9 AM
        public void sendDailyEmail() {
            String recipient = "your-email@gmail.com";  // Change to the user's email
            String javaTip = chatGPTService.getJavaTip();  // Fetch Java tip from ChatGPT

            emailService.sendEmail(recipient, "Daily Java Tip", javaTip);

            System.out.println("Daily Java tip sent at 9 AM!");
        }
    }


