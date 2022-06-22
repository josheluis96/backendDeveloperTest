package com.example.demo.domain;

import lombok.Data;

@Data
public class Response {

	private String messageDescription;
	private PtClient client;
	private PtStore store;
	private PtProduct product;
	
}
