package com.creditas.clientes.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditas.clientes.model.CreditoModel;
import com.creditas.clientes.service.CreditoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/V1/credito")
@Api(value = "Credito", description = "Servicio de Credito ")
public class CreditoController {

	@Autowired
	CreditoService creditoService;

	@ApiOperation(value = "Obtiene Información de Credito", httpMethod = "GET" )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Correcto"),
			@ApiResponse(code = 204, message = "Sin resultados"),
			@ApiResponse(code = 500, message = "Error")
	
	})
	@GetMapping("/{idCredito}" )
	public CreditoModel obtieneCredito(@PathVariable String idCredito) {
		return creditoService.obtieneCredito(idCredito);
	}

	@ApiOperation(value = "Guarda la Información de crédito", httpMethod = "POST" )
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Insertado"),
			@ApiResponse(code = 400, message = "Información Incorrecta"),
			@ApiResponse(code = 500, message = "Error")
	
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CreditoModel guardaCredito(@Valid @RequestBody CreditoModel creditoModel) {
		return creditoService.guardaCredito(creditoModel);
	}

}
