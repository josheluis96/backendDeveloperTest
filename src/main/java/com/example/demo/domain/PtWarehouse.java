package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PT_WAREHOUSE")
public class PtWarehouse {
    @Id
    @Column(name = "ID_WAREHOUSE", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STORE_FK")
    private PtStore idStoreFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT_FK")
    private PtProduct idProductFk;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;



}