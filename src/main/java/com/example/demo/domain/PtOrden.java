package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PT_ORDEN")
public class PtOrden {
    @Id
    @Column(name = "ID_ORDEN", nullable = false)
    private Long id;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;



}