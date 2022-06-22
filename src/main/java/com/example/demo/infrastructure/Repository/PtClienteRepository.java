package com.example.demo.infrastructure.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PtClient;

@Repository
public interface PtClienteRepository extends JpaRepository<PtClient, Long> {

	public PtClient findByCodClient(String codClient);
}
