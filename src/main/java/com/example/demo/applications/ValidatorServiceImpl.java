package com.example.demo.applications;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.example.demo.domain.PtClient;
import com.example.demo.domain.PtProduct;
import com.example.demo.domain.PtStore;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ValidatorServiceImpl implements ValidatorServiceInt {

	@Override	
	public  Validator createValidator() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		Validator validator = factory.getValidator();
		factory.close();
		return validator;
	}

	@Override
	public Set<ConstraintViolation<PtClient>> validaViolations(PtClient client) {
		Validator validator = createValidator();
		Set<ConstraintViolation<PtClient>> violations = validator.validate(client);
		violations.stream().forEach(x-> log.warn(x.getPropertyPath()+": "+ x.getMessage()));
		return violations;
	}
	
	@Override
	public Long generateID() {
		Calendar fecha = Calendar.getInstance();
		String generate = String.valueOf(fecha.get(Calendar.YEAR)) + String.valueOf(fecha.get(Calendar.MONTH) + 1)
		+ String.valueOf(fecha.get(Calendar.DATE)) + String.valueOf(fecha.get(Calendar.HOUR))
		+ String.valueOf(fecha.get(Calendar.MINUTE)) + String.valueOf(fecha.get(Calendar.SECOND))
		+ String.valueOf(fecha.get(Calendar.MILLISECOND));
		return Long.parseLong(generate);
	}

	@Override
	public Set<ConstraintViolation<PtStore>> validaViolations(PtStore client) {
		Validator validator = createValidator();
		Set<ConstraintViolation<PtStore>> violations = validator.validate(client);
		violations.stream().forEach(x-> log.warn(x.getPropertyPath()+": "+ x.getMessage()));
		return violations;
	}

	@Override
	public Set<ConstraintViolation<PtProduct>> validaViolations(PtProduct client) {
		Validator validator = createValidator();
		Set<ConstraintViolation<PtProduct>> violations = validator.validate(client);
		violations.stream().forEach(x-> log.warn(x.getPropertyPath()+": "+ x.getMessage()));
		return violations;
	}

}
