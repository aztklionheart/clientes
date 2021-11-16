package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "MUNICIPIO")
@Data
public class MunicipioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long idMunicipio;

	private String nombreMunicipio;

	@ManyToOne
	private EntidadFederativaEntity entidadFederativaEntity;

}
