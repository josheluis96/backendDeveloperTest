package com.example.demo.infrastructure.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.PtStore;

@Repository
public interface PtStoreRepository extends JpaRepository<PtStore, Long> {

	public PtStore findByCodStore(String codStore);
}
