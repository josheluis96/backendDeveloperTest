package com.example.demo.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.PtStore;
import com.example.demo.infrastructure.Repository.PtStoreRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ServiceStoreImpl implements ServiceStoreInt {
	
	@Autowired
	PtStoreRepository clienteRepository;
	


	@Override
	public PtStore saveptStore(PtStore client) {
		

			return clienteRepository.save(client);

	}



	@Override
	public PtStore findByCodStore(PtStore client) {
		return clienteRepository.findByCodStore(client.getCodStore());
	}



	@Override
	public boolean deleteStore(PtStore client) {
		try {
			clienteRepository.deleteById(client.getId());
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		} 
	}

}
