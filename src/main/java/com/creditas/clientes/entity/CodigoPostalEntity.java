package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CP")
@Data
public class CodigoPostalEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CP")
	private Long idCodigoPostal;

	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;

	@ManyToOne
	private MunicipioEntity municipio;
}
