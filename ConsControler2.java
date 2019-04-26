package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsControler2 {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	public void getEmpDetails() {
        List<ServiceInstance> instance = discoveryClient.getInstances("producer");
        ServiceInstance serviceInstance = instance.get(0);
        
        String baseUri = instance.get(0).getUri().toString();
		baseUri += "/employee";
                       RestTemplate restTemplate = new RestTemplate();
                       
                       try {
                                     ResponseEntity<String> response = restTemplate.exchange(baseUri, HttpMethod.GET, getHeaders(),String.class);
                       
                       
                       System.out.println("response:::::"+response.getBody());
                       }catch(Exception e) {
                                     System.out.println(e);
                       }

		
	}
	
	
	  private HttpEntity<String> getHeaders() {
	        HttpHeaders headers = new HttpHeaders();
	        
	        headers.set("Accept", org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
	        return new HttpEntity(headers);
	}

}
