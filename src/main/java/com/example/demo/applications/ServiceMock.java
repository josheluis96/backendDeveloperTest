package com.example.demo.applications;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceMock {
	
	
	@Value("${mock}")
	private String mock;
	
	public String mockproductos() {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(mock, String.class);
	}

}
