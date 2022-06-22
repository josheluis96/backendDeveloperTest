package com.example.demo.applications;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.example.demo.domain.PtClient;
import com.example.demo.domain.PtProduct;
import com.example.demo.domain.PtStore;

public interface ValidatorServiceInt {
	public Validator createValidator();
	
	public Set<ConstraintViolation<PtClient>> validaViolations(PtClient client);
	
	public Set<ConstraintViolation<PtStore>> validaViolations(PtStore client);
	
	public Set<ConstraintViolation<PtProduct>> validaViolations(PtProduct client);
	
	public Long generateID();
}
