package com.example.demo.applications;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceMock {
	
	
	
	
	public String mockproductos() {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://mocki.io/v1/1433de08-c38a-47da-b941-35d3fbeba824", String.class);
	}

}
