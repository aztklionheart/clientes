package com.creditas.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditas.clientes.model.TipoCreditoModel;
import com.creditas.clientes.service.TipoCreditoService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/V1/TipoCredito")
@Api(value = "Credito", description = "Servicio de Tipo Credito ")
public class TipoCreditoController {

	@Autowired
	TipoCreditoService tipoCreditoService;

	@GetMapping
	List<TipoCreditoModel> buscaTipoCredito() {

		List<TipoCreditoModel> lstTipoCredModel = tipoCreditoService.buscaTipoCredito();

		return lstTipoCredModel;

	}

}
