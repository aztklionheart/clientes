package com.creditas.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditas.clientes.errorhandling.NoContentException;
import com.creditas.clientes.model.EmpresaModel;
import com.creditas.clientes.service.EmpresaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/V1/empresa")
@Api(value = "Empresa", description = "Servicio de Empresa ")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@GetMapping
	public List<EmpresaModel> obtieneEmpresas() {

		List<EmpresaModel> lstEmpModel = empresaService.obtieneEmpresas();

		if (lstEmpModel.isEmpty()) {
			throw new NoContentException();
		}
		return lstEmpModel;
	}

	@GetMapping("/autocomplete/{query}")
	public List<EmpresaModel> autocompleteEmpresas(@PathVariable String query) {

		List<EmpresaModel> lstEmpModel = empresaService.autoCompleteEmpresas(query);

		if (lstEmpModel.isEmpty()) {
			throw new NoContentException();
		}
		return lstEmpModel;

	}

}
