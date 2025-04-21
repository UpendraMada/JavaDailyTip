package com.upendra.java_daily_tip.Service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService {

    @Value("${OPENAI_API_KEY}")
    private String openaiApikey;

    private static final String API_URL = "https://api.openai.com/v1/completions";

    public String getJavaTip(){
        RestTemplate restTemplate = new RestTemplate();
        String requestBody = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"prompt\": \"Give me a useful Java programming tip.\","
                + "\"max_tokens\": 50"
                + "}";
        // headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openaiApikey);  // Automatically adds "Bearer " prefix

        // Wrap the body and headers into the request entity
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // Make the POST call to OpenAI
        ResponseEntity<String> response = restTemplate.exchange(
                API_URL,
                HttpMethod.POST,
                request,
                String.class
        );

        return response.getBody();
    }



}
