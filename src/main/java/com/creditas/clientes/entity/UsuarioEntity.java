package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USUARIO")
@Data
public class UsuarioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombreUsuario;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String correoElectronico;
	private String rfc;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DIRECCION")
	private DireccionEntity direccionEntity;

}
