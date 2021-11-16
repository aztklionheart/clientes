package com.creditas.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditas.clientes.model.EmpresaModel;
import com.creditas.clientes.repository.EmpresaRepository;
import com.creditas.clientes.utils.MapperHelper;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;

	public List<EmpresaModel> obtieneEmpresas() {

		return MapperHelper.mapList(empresaRepository.findAll(), EmpresaModel.class);

	}

	public List<EmpresaModel> autoCompleteEmpresas(String query) {

		return MapperHelper.mapList(empresaRepository.findByNombreEmpresaLikeIgnoreCase("%" + query + "%"),
				EmpresaModel.class);

	}

}
