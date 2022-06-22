package com.example.demo.infrastructure.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PtProduct;


@Repository
public interface PtProductRepository extends JpaRepository<PtProduct, Long> {

	public PtProduct findByCodProduct(String codStore);
}
