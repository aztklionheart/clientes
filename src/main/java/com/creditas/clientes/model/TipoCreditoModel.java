package com.creditas.clientes.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Tipo Crédito" )
public class TipoCreditoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, value = "Identificador del tipo de crédito", example = "1", required = true, dataType = "Long")
	@Min(value = 1)
	@Max(value = 3)
	private Long idTipoCredito;

	@ApiModelProperty(position = 2, value = "Descripción del tipo de crédito", example = "Auto", required = false, dataType = "String")
	private String tipoCredito;

}
