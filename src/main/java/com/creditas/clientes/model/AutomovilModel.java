package com.creditas.clientes.model;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Objeto Automivil" )
public class AutomovilModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1, value = "Identificador del carro", example = "1", required = false, dataType = "Long", hidden = true)
	private Long idAutomovil;

	@ApiModelProperty(position = 2, value = "Marca del carro", example = "Hyundai", required = true, dataType = "String")
	@NotBlank
	private String marca;

	@ApiModelProperty(position = 3, value = "Modelo del carro", example = "Elantra", required = true, dataType = "String")
	@NotBlank
	private String modelo;

	@ApiModelProperty(position = 4, value = "Año del carro", example = "2019", required = true, dataType = "Integer")
	@DecimalMin(value = "1900")
	@DecimalMax(value = "2022")
	private String generacion;

	@ApiModelProperty(position = 5, value = "Valor del carro", example = "159000", required = true, dataType = "Integer")
	@NotBlank
	@Positive
	private String valor;

}
