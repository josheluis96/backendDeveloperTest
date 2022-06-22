package com.example.demo.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.PtClient;
import com.example.demo.infrastructure.Repository.PtClienteRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ServiceClienteImpl implements ServiceClienteInt {
	
	@Autowired
	PtClienteRepository clienteRepository;
	


	@Override
	public PtClient saveptcliente(PtClient client) {
		

			return clienteRepository.save(client);

	}



	@Override
	public PtClient findByCodClient(PtClient client) {
		return clienteRepository.findByCodClient(client.getCodClient());
	}



	@Override
	public boolean deleteCliente(PtClient client) {
		try {
			clienteRepository.deleteById(client.getId());
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		} 
	}

}
