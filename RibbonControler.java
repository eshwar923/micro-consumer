package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class RibbonControler {
	
	@Autowired
	LoadBalancerClient loadBal;

	public void fetchEmp() {
		ServiceInstance inst = loadBal.choose("emp-zuul");

		String baseUri = inst.getUri().toString();
		baseUri += "/producer/employee";
		RestTemplate restTemplate = new RestTemplate();

		try {
			ResponseEntity<String> response = restTemplate.exchange(baseUri, HttpMethod.GET, getHeaders(),
					String.class);

			System.out.println("response:::::" + response.getBody());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private HttpEntity<String> getHeaders() {
		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity(headers);
	}
	
}
