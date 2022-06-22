package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PT_RULES_TYPES", indexes = {
        @Index(name = "COD_RULE_TYPE_UNIQUE", columnList = "COD_RULE_TYPE", unique = true)
})
public class PtRulesType {
    @Id
    @Column(name = "ID_RULE_TYPE", nullable = false)
    private Long id;

    @Column(name = "COD_RULE_TYPE", nullable = false, length = 50)
    private String codRuleType;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    private String description;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;



}