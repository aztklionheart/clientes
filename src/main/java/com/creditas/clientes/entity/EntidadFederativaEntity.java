package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ESTADO")
@Data
public class EntidadFederativaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ESTADO")
	private Long idEntidadFederativa;
	@Column(name = "NOMBRE_ESTADO")
	private String nombreEntidadFederativa;

}
