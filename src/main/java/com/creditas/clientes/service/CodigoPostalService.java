package com.creditas.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditas.clientes.entity.ColoniaEntity;
import com.creditas.clientes.model.CodigoPostalModel;
import com.creditas.clientes.model.ColoniaModel;
import com.creditas.clientes.repository.CodigoPostalRepository;
import com.creditas.clientes.repository.ColoniaRepository;
import com.creditas.clientes.utils.MapperHelper;

@Service
public class CodigoPostalService {

	@Autowired
	CodigoPostalRepository codigoPostalRepository;

	@Autowired
	ColoniaRepository coloniaRepository;

	public CodigoPostalModel obtieneColonias(String codigoPostal) {

		String cp = codigoPostal.startsWith("0") ? codigoPostal.substring(1, codigoPostal.length()) : codigoPostal;

		CodigoPostalModel codigoPostalModel = new CodigoPostalModel();

		List<ColoniaEntity> lstColoniaEntity = coloniaRepository.buscaPorCP(cp);

		codigoPostalModel.setMunicipio(codigoPostalRepository.findMuinicipioByCodigoPostal(cp));
		codigoPostalModel.setEstado(codigoPostalRepository.findEstadoByCodigoPostal(cp));
		codigoPostalModel.setColoniaModel(MapperHelper.mapList(lstColoniaEntity, ColoniaModel.class));

		return codigoPostalModel;

	}

}
