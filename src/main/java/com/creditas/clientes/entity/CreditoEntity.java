package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CREDITO")
@Data
public class CreditoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idCredito;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TIPO_CREDITO")
	private TipoCreditoEntity tipoCreditoEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuarioEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_EMPRESA")
	private EmpresaEntity empresaEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DIRECCION")
	private DireccionEntity direccionEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_AUTOMOVIL")
	private AutomovilEntity automovilEntity;

	private String estatus;

}
