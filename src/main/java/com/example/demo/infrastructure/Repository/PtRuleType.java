package com.example.demo.infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.PtRulesType;

public interface PtRuleType extends JpaRepository<PtRulesType, Long> {

}
