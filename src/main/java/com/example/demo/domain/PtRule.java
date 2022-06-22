package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PT_RULES")
public class PtRule {
    @Id
    @Column(name = "ID_RULE", nullable = false)
    private Long id;

    @Column(name = "MINIMUM")
    private Long minimum;

    @Column(name = "MAXIMUM")
    private Long maximum;

    @Column(name = "ACTION", length = 1)
    private String action;

    @Column(name = "ADDSTOCK")
    private Long addstock;

    @Column(name = "PROCESSTYPE", length = 1)
    private String processtype;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;



}