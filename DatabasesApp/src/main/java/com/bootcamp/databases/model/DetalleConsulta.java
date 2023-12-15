package com.bootcamp.databases.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "detalleConsulta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@Column(name = "diagnostico", nullable = false, length = 200)
	private String diagnostico;
	@Column(name = "tratamiento", nullable = false, length = 250)
	private String tratamiento;
	@Column(name = "consulta", nullable = false)
	private int idConsulta;

}
