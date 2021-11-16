package com.creditas.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditas.clientes.service.ColoniaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/V1/colonia")
@Api(value = "Colonia", description = "Servicio de Colonia ")
public class ColoniaController {

	@Autowired
	ColoniaService coloniaService;

	@GetMapping
	@ApiOperation(value = "Obtiene Información de Colonias", httpMethod = "GET" )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Correcto"),
			@ApiResponse(code = 204, message = "Sin resultados"),
			@ApiResponse(code = 500, message = "Error")
	
	})
	public Object obtieneColonias(String cp) {
		return coloniaService.obtieneColoniaPorCP(cp);
	}

}
