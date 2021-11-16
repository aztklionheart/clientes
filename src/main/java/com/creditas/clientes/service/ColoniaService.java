package com.creditas.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditas.clientes.repository.ColoniaRepository;

@Service
public class ColoniaService {

	@Autowired
	ColoniaRepository coloniaRepository;

	public Object obtieneColoniaPorCP(String cp) {

		String ncp = cp.startsWith("0") ? cp.substring(1, cp.length()) : cp;
		return coloniaRepository.buscaPorCP(ncp);
	}
}
