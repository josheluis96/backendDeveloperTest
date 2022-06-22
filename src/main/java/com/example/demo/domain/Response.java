package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Response {

	private String messageDescription;
	private List<PtClient> client = new ArrayList<>(1);
	private List<PtStore> store= new ArrayList<>(1);
	private List<PtProduct> product= new ArrayList<>(1);
	
}
