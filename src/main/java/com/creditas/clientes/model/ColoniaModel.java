package com.creditas.clientes.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Colonia" )
public class ColoniaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, value = "Identificador de la colonia", example = "1", required = true, dataType = "String")
	private Long idColonia;

	@ApiModelProperty(position = 2, value = "Nombre de la colonia", example = "San Pedro", required = true, dataType = "String")
	private String nombreColonia;

	@ApiModelProperty(position = 3, value = "Tipo de Asentamiento", example = "Colonia", required = true, dataType = "String")
	private String tipoAsentamiento;

	@ApiModelProperty(position = 4, value = "Codigo postal", example = "54150", required = true, dataType = "String")
	private String codigoPostal;

}
