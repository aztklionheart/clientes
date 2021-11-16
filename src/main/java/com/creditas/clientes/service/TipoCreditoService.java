package com.creditas.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditas.clientes.model.TipoCreditoModel;
import com.creditas.clientes.repository.TipoCreditoRepository;
import com.creditas.clientes.utils.MapperHelper;

@Service
public class TipoCreditoService {

	@Autowired
	TipoCreditoRepository tipoCreditoRepository;

	public List<TipoCreditoModel> buscaTipoCredito() {

		return MapperHelper.mapList(tipoCreditoRepository.findAll(), TipoCreditoModel.class);

	}

}
