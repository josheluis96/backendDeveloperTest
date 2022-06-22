package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PT_PRODUCT", indexes = {
        @Index(name = "COD_PRODUCT_UNIQUE", columnList = "COD_PRODUCT", unique = true)
})
public class PtProduct {
    @Id
    @Column(name = "ID_PRODUCT", nullable = false)
    private Long id;

    @Column(name = "COD_PRODUCT", nullable = false, length = 50)
    private String codProduct;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    public PtProduct(String codProduct, String status) {
		super();
		this.codProduct = codProduct;
		this.status = status;
	}

	@Column(name = "PRICE")
    private Long price;

    @Column(name = "STOCK")
    private Long stock;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;



}