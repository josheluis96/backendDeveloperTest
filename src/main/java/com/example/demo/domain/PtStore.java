package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PT_STORE", indexes = {
        @Index(name = "COD_STORE_UNIQUE", columnList = "COD_STORE", unique = true)
})
public class PtStore {
    @Id
    @Column(name = "ID_STORE", nullable = false)
    private Long id;

    @Column(name = "COD_STORE", nullable = false, length = 50)
    private String codStore;

    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    private String description;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "STATUS", length = 1)
    private String status;

	public PtStore(String codStore, String status) {
		super();
		this.codStore = codStore;
		this.status = status;
	}


}