package com.upendra.java_daily_tip.Service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTService {

    @Value("${OPENAI_API_KEY}")
    private String openaiApikey;


}
