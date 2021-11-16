package com.creditas.clientes.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Empresa" )
public class EmpresaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, value = "Identificador de la Empresa", example = "1", required = false, dataType = "Long", hidden = true)
	private Long idEmpresa;

	@ApiModelProperty(position = 2, value = "Nombre de la Empresa", example = "Microsoft", required = true, dataType = "String")
	@NotBlank
	private String nombreEmpresa;

	@ApiModelProperty(position = 3, value = "Fecha de ingreso a la Empresa", example = "2020-11-13", required = true, dataType = "LocalDate")
	@PastOrPresent
	private LocalDate fechaIngreso;
}
