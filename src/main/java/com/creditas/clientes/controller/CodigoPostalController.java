package com.creditas.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditas.clientes.model.CodigoPostalModel;
import com.creditas.clientes.service.CodigoPostalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/V1/cp")
@Api(value = "Codigo Postal",  description = "Servicio de Codigo Postal " )
public class CodigoPostalController {

	@Autowired
	CodigoPostalService codigoPostalService;

	
	@ApiOperation(value = "Obtiene Colonias", httpMethod = "GET" )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Correcto"),
			@ApiResponse(code = 204, message = "Sin resultados"),
			@ApiResponse(code = 500, message = "Error")
	
	})
	@GetMapping("/{codigoPostal}")
	public CodigoPostalModel obtieneColonias( @PathVariable String codigoPostal) {

		return codigoPostalService.obtieneColonias(codigoPostal);

	}

}
