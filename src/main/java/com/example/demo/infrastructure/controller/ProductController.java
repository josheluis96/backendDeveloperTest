package com.example.demo.infrastructure.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.example.demo.applications.ServiceMock;
import com.example.demo.applications.ServiceProductInt;
import com.example.demo.applications.ValidatorServiceInt;
import com.example.demo.domain.PtProduct;
import com.example.demo.domain.Response;

import lombok.extern.log4j.Log4j2;



@Log4j2
@RestController
@RequestMapping(value = "/registro")
public class ProductController {
	
	@Autowired
	ValidatorServiceInt validatorServiceInt;
	
	@Autowired
	ServiceProductInt clienteInt;
	
	@Autowired
	ServiceMock mock;
	
	@PostMapping(value = "/product")
	public ResponseEntity < Response > insertClient(@RequestBody PtProduct client) {
		Response res = new Response();
		try {
			client.setId(validatorServiceInt.generateID());
			Set<ConstraintViolation<PtProduct>> violation = validatorServiceInt.validaViolations(client);
			if(violation.stream().count()>0) {
				res.setMessageDescription("Estructura incorrecta ");
				violation.stream().forEach(x-> {res.setMessageDescription(res.getMessageDescription()+", "+x.getPropertyPath()+": "+x.getMessage());});
				return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
			}else {
				PtProduct client2 = clienteInt.findByCodProduct(client);
				if(client2==null) 
				{
					client.setRegistrationDate(LocalDate.now());
					client.setUpdateDate(null);
					res.getProduct().add(clienteInt.savePtProduct(client));
					return new ResponseEntity<>(res, HttpStatus.CREATED); 
				}else {
					res.setMessageDescription("Cliente ya registrado");
					res.getProduct().add(client);
					return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
				}

			}
			
		} catch (Exception e) {
			res.setMessageDescription(e.getMessage());
			res.getProduct().add(client);
			log.error(e);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/product")
	public ResponseEntity < Response > findbyClient(@RequestParam @NotNull String identificacion) {
		Response res = new Response();
		try {
			PtProduct client2 = clienteInt.findByCodProduct(new PtProduct(identificacion,"A"));
				if(client2==null) 
				{
					res.setMessageDescription("Cliente no registrado");
					return new ResponseEntity<>(res, HttpStatus.OK); 
				}else {
					res.setMessageDescription("Cliente registrado");
					res.getProduct().add(client2);					
					return new ResponseEntity<>(res, HttpStatus.OK); 
				}
	
		} catch (Exception e) {
			res.setMessageDescription(e.getMessage());
			log.error(e);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping(value = "/product")
	public ResponseEntity < Response > actualizarClient(@RequestBody PtProduct client) {
		Response res = new Response();
		try {


			PtProduct client2 = clienteInt.findByCodProduct(client);
				if(client2==null) 
				{
					res.setMessageDescription("Cliente no encontrado");
					return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
				}else {
					client.setUpdateDate(LocalDate.now());
					
					res.setMessageDescription("Cliente actualizado");
					res.getProduct().add(clienteInt.savePtProduct(client));
					
					return new ResponseEntity<>(res, HttpStatus.OK); 
				}

			
			
		} catch (Exception e) {
			res.setMessageDescription(e.getMessage());
			res.getProduct().add(client);
			log.error(e);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
@PutMapping(value = "/product/mock")
public ResponseEntity < Response > mockProducto() {
	Response res = new Response();
	try {

		JSONObject jsonObject = new JSONObject(mock.mockproductos());
		
		 JSONArray values =  jsonObject.getJSONArray("prods");
		  for (int i = 0; i < values.length(); i++) {
			    
			    JSONObject animal = values.getJSONObject(i); 

			    
			    PtProduct client = new PtProduct();
			    client.setCodProduct(animal.getString("cod"));
			    client.setName(animal.getString("name"));
			    client.setPrice(animal.getLong("price"));
			    client.setStock(animal.getLong("stock"));
			    insertClient(client);
			  }
		 
		return new ResponseEntity<>(res, HttpStatus.OK);
	} catch (Exception e) {
		res.setMessageDescription(e.getMessage());
		log.error(e);
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
}}

@GetMapping(value = "/product/mock")
public ResponseEntity < Response > mockProductoAll() {
	Response res = new Response();
	try {

		JSONObject jsonObject = new JSONObject(mock.mockproductos());
		
		 JSONArray values =  jsonObject.getJSONArray("prods");
		  for (int i = 0; i < values.length(); i++) {
			    
			    JSONObject animal = values.getJSONObject(i); 
			    PtProduct client = new PtProduct();
			    client.setCodProduct(animal.getString("cod"));
			    client.setName(animal.getString("name"));
			    client.setPrice(animal.getLong("price"));
			    client.setStock(animal.getLong("stock"));
			    res.getProduct().add(client);
			  }
		 
		return new ResponseEntity<>(res, HttpStatus.OK);
	} catch (Exception e) {
		res.setMessageDescription(e.getMessage());
		log.error(e);
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
}}


}
