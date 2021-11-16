package com.creditas.clientes.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TIPO_CREDITO")
@Data
public class TipoCreditoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long idTipoCredito;

	private String tipoCredito;

}
