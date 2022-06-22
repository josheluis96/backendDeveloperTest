package com.example.demo.infrastructure.controller;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.applications.ServiceClienteInt;
import com.example.demo.applications.ValidatorServiceInt;
import com.example.demo.domain.PtClient;
import com.example.demo.domain.Response;

import lombok.extern.log4j.Log4j2;



@Log4j2
@RestController
@RequestMapping(value = "/registro")
public class ClienteController {
	
	@Autowired
	ValidatorServiceInt validatorServiceInt;
	
	@Autowired
	ServiceClienteInt clienteInt;
	
	@PostMapping(value = "/customer")
	public ResponseEntity < Response > insertClient(@RequestBody PtClient client) {
		Response res = new Response();
		try {
			client.setId(validatorServiceInt.generateID());
			Set<ConstraintViolation<PtClient>> violation = validatorServiceInt.validaViolations(client);
			if(violation.stream().count()>0) {
				res.setMessageDescription("Estructura incorrecta ");
				violation.stream().forEach(x-> {res.setMessageDescription(res.getMessageDescription()+", "+x.getPropertyPath()+": "+x.getMessage());});
				return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
			}else {
				PtClient client2 = clienteInt.findByCodClient(client);
				if(client2==null) 
				{
					client.setRegistrationDate(LocalDate.now());
					client.setUpdateDate(null);
					res.setClient(clienteInt.saveptcliente(client));
					return new ResponseEntity<>(res, HttpStatus.CREATED); 
				}else {
					res.setMessageDescription("Cliente ya registrado");
					res.setClient(client2);
					return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
				}

			}
			
		} catch (Exception e) {
			res.setMessageDescription(e.getMessage());
			res.setClient(client);
			log.error(e);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/customer")
	public ResponseEntity < Response > findbyClient(@RequestParam @NotNull String identificacion) {
		Response res = new Response();
		try {
				PtClient client2 = clienteInt.findByCodClient(new PtClient(identificacion,"A"));
				if(client2==null) 
				{
					res.setMessageDescription("Cliente no registrado");
					return new ResponseEntity<>(res, HttpStatus.OK); 
				}else {
					res.setMessageDescription("Cliente registrado");
					res.setClient(client2);
					return new ResponseEntity<>(res, HttpStatus.OK); 
				}
	
		} catch (Exception e) {
			res.setMessageDescription(e.getMessage());
			log.error(e);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping(value = "/customer")
	public ResponseEntity < Response > actualizarClient(@RequestBody PtClient client) {
		Response res = new Response();
		try {


				PtClient client2 = clienteInt.findByCodClient(client);
				if(client2==null) 
				{
					res.setMessageDescription("Cliente no encontrado");
					return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
				}else {
					client.setUpdateDate(LocalDate.now());
					
					res.setMessageDescription("Cliente actualizado");
					res.setClient(clienteInt.saveptcliente(client));
					return new ResponseEntity<>(res, HttpStatus.OK); 
				}

			
			
		} catch (Exception e) {
			res.setMessageDescription(e.getMessage());
			res.setClient(client);
			log.error(e);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	


}