package com.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerController {
	
	public void fetchEmp() {
		System.out.println("fetchEmp====");
		RestTemplate restTemp = new RestTemplate();
		
		ResponseEntity<String> response = restTemp.exchange("http://localhost:2019/employee", HttpMethod.GET, getHeaders(),String.class);
        System.out.println("response:::::"+response.getBody());
		
	}

	
    private HttpEntity<String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        
        headers.set("Accept", org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity(headers);
}

	
}
