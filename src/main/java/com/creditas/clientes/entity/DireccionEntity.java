package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DIRECCION")
@Data
public class DireccionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDireccion;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = true)
	@JoinColumn(name = "ID_COLONIA", insertable = false)
	private ColoniaEntity coloniaEntity;

	private String calle;

	private String numeroExterior;
	private String numeroInterior;

}
