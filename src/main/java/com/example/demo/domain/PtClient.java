package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PT_CLIENTS", indexes = {
        @Index(name = "COD_CLIENT_UNIQUE", columnList = "COD_CLIENT", unique = true)
})
public class PtClient {
    public PtClient(@NotNull String codClient) {
		super();
		this.codClient = codClient;
	}

	@Id
    @Column(name = "ID_CLIENT", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "COD_CLIENT", nullable = false, length = 50)
    private String codClient;
    
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "PHOTO", nullable = false, length = 500)
    private String photo;

    public PtClient(@NotNull String codClient,
			@NotNull @Pattern(regexp = "(A)|(I)", message = "Valor incorrecto, Activo: A - Inactivo I") String status) {
		super();
		this.codClient = codClient;
		this.status = status;
	}

	@Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @NotNull
    @Pattern(regexp="(A)|(I)", message = "Valor incorrecto, Activo: A - Inactivo I")
    @Column(name = "STATUS", length = 1)
    private String status;



}