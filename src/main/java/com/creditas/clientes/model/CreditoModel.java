package com.creditas.clientes.model;

import java.io.Serializable;

import javax.validation.Valid;

import com.creditas.clientes.validation.ValidaTipoCredito;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Crédito" )
@ValidaTipoCredito(dependFieldName = "automovilModel", fieldValue = "1", message = " tipoCreditoModel.idTipoCredito tiene valor 1, no debe ser nulo ")
@ValidaTipoCredito(dependFieldName = "direccionCasa", fieldValue = "2", message = " tipoCreditoModel.idTipoCredito tiene valor 2, no debe ser nulo ")
@ValidaTipoCredito(dependFieldName = "empresaModel", fieldValue = "3", message = " tipoCreditoModel.idTipoCredito tiene valor 3, no debe ser nulo ")
@ValidaTipoCredito(dependFieldName = "usuarioModel.direccionUsuario.coloniaModel", fieldValue = "1", message = " ERROR - ERROR ")
public class CreditoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, value = "Identificador del crédito", example = "1", required = false, dataType = "Long" )
	private String idCredito;


	@Valid
	private UsuarioModel usuarioModel;


	@Valid
	private TipoCreditoModel tipoCreditoModel;


	@Valid
	private DireccionModel direccionCasa;


	@Valid
	private EmpresaModel empresaModel;


	@Valid
	private AutomovilModel automovilModel;

	@ApiModelProperty(position = 2, value = "Estado del crédito", example = "1", required = false, dataType = "String" )
	private String estatus;

}
