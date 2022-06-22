package com.example.demo.infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.PtRule;

public interface PrReglaRepository extends JpaRepository<PtRule, Long> {

}
