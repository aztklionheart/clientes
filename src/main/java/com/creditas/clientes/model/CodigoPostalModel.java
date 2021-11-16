package com.creditas.clientes.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Codigo Postal" )
public class CodigoPostalModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, value = "Lista de Colonias", required = true, dataType = "List")
	private List<ColoniaModel> coloniaModel;
	@ApiModelProperty(position = 2, value = "Nombre del Municipio", example = "Naucalpan de Juarez", required = true, dataType = "String")
	private String municipio;
	@ApiModelProperty(position = 3, value = "Nombre del Estado", example = "Estado de México", required = true, dataType = "String")
	private String estado;

}
