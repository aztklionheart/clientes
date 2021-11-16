package com.creditas.clientes.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.creditas.clientes.validation.RFC;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Objeto Usuario" )
public class UsuarioModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, value = "Identificador del usuario", example = "1636955995908SADV830614P591", required = false, dataType = "Long", hidden = true)
	private Long idUsuario;

	@ApiModelProperty(position = 2, value = "Nombre del usuario", example = "Victor", required = true, dataType = "String")
	@NotBlank(message = "No puede ser nulo")
	private String nombreUsuario;

	@ApiModelProperty(position = 3, value = "Primer Apellido del usuario", example = "Santana", required = true, dataType = "String")
	@NotBlank(message = "No puede ser nulo")
	private String primerApellido;

	@ApiModelProperty(position = 4, value = "Segundo Apellido del usuario", example = "Delgadillo", required = true, dataType = "String")
	private String segundoApellido;

	@ApiModelProperty(position = 5, value = "Telefono del usuario", example = "5577262181", required = true, dataType = "Number")
	@Size(min = 0, max = 10)
	private String telefono;

	@ApiModelProperty(position = 6, value = "Correo Electrónico del usuario", example = "va.santanad@gmail.com", required = true, dataType = "String")
	@Email
	@NotBlank(message = "No puede ser nulo")
	private String correoElectronico;

	@ApiModelProperty(position = 7, value = "RFC del usuario", example = "SADV830614P59", required = true, dataType = "String")
	@RFC
	private String rfc;

	@Valid
	private DireccionModel direccionUsuario;
}
