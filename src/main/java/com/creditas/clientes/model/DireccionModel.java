package com.creditas.clientes.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Dirección" )
public class DireccionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1, value = "Identificador del usuario", example = "1", required = false, dataType = "Long", hidden = true)
	private Long idDireccion;
	
	@ApiModelProperty(position = 2, value = "Calle de la Dirección", example = " Bravo ", required = true, dataType = "String")
	@NotBlank
	private String calle;
	
	@ApiModelProperty(position = 3, value = "Número de la Dirección", example = " 3 ", required = true, dataType = "String")
	@NotBlank
	private String numeroExterior;
	
	@ApiModelProperty(position = 4, value = "Número Interior de la Dirección", example = " 2 ", required = false, dataType = "String")
	private String numeroInterior;

	
	@Valid
	private ColoniaModel coloniaModel;

}
