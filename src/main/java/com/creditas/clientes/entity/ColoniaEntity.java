package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COLONIA")
@Data
public class ColoniaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long idColonia;
	private String nombreColonia;
	private String tipoAsentamiento;
	private String codigoPostal;

}
