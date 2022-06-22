package com.example.demo.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.PtProduct;
import com.example.demo.infrastructure.Repository.PtProductRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ServiceProductImpl implements ServiceProductInt {
	
	@Autowired
	PtProductRepository clienteRepository;
	


	@Override
	public PtProduct savePtProduct(PtProduct client) {
		

			return clienteRepository.save(client);

	}



	@Override
	public PtProduct findByCodProduct(PtProduct client) {
		return clienteRepository.findByCodProduct(client.getCodProduct());
	}



	@Override
	public boolean deleteProduct(PtProduct client) {
		try {
			clienteRepository.deleteById(client.getId());
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		} 
	}

}
