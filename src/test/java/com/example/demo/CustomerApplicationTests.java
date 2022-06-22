package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.infrastructure.Repository.PtRuleType;

@SpringBootTest
class CustomerApplicationTests {

	@Autowired
	PtRuleType ptRuleType;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void Parametros() {
		
		assertEquals(true, ptRuleType.findAll().stream().filter(x-> x.getStatus().equalsIgnoreCase("A")).count()>0);
	}
	

}
