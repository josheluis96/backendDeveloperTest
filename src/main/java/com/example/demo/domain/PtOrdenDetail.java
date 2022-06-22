package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PT_ORDEN_DETAIL")
public class PtOrdenDetail {
    @Id
    @Column(name = "ID_ORDEN_DETAIL", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORDEN_FK")
    private PtOrden idOrdenFk;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "QUANTITY_PRODUCTS")
    private Long quantityProducts;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;

}