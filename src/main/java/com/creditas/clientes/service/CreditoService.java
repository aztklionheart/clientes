package com.creditas.clientes.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditas.clientes.entity.CreditoEntity;
import com.creditas.clientes.errorhandling.BadRequestException;
import com.creditas.clientes.model.CreditoModel;
import com.creditas.clientes.repository.CodigoPostalRepository;
import com.creditas.clientes.repository.CreditoRepository;
import com.creditas.clientes.repository.DireccionRepository;
import com.creditas.clientes.repository.UsuarioRepository;
import com.creditas.clientes.utils.MapperHelper;

@Service
public class CreditoService {

	@Autowired
	CreditoRepository creditoRepository;

	@Autowired
	DireccionRepository direccionRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	CodigoPostalRepository codigoPostalRepository;

	public List<CreditoModel> obtieneCredito() {

		return MapperHelper.mapList(creditoRepository.findAll(), CreditoModel.class);
	}

	public CreditoModel obtieneCredito(String idCredito) {

		return MapperHelper.map(creditoRepository.findById(idCredito).get(), CreditoModel.class);
	}

	public CreditoModel guardaCredito(CreditoModel creditoModel) {

		CreditoEntity creditoEntity = MapperHelper.map(creditoModel, CreditoEntity.class);

		Integer count = creditoRepository.validaRechazado(creditoEntity.getUsuarioEntity().getRfc() ,  creditoEntity.getTipoCreditoEntity().getIdTipoCredito() );
		
		if (!count.equals(0)) {
			throw new BadRequestException("Ya existe un registro rechazado con ese RFC y ese tipo de credito");
		}
		
		boolean flag = false;

		// validar precioAuto

		if (creditoEntity.getTipoCreditoEntity().getIdTipoCredito().equals(1L)) {

			Double valor = Double.valueOf(creditoEntity.getAutomovilEntity().getValor());

			Double min = 200000.00;
			Double max = 500000.00;

			if (valor > max | valor < min) {
				flag = true;
			}

		}
		// validar direccion
		if (creditoEntity.getTipoCreditoEntity().getIdTipoCredito().equals(2L)) {

			String cp = creditoEntity.getDireccionEntity().getColoniaEntity().getCodigoPostal();

			String estado = codigoPostalRepository.validaDomicilio(cp);

			flag = estado.isEmpty();

		}

		// validar antiguedad trabajo
		if (creditoEntity.getTipoCreditoEntity().getIdTipoCredito().equals(3L)) {

			LocalDate ingreso = creditoEntity.getEmpresaEntity().getFechaIngreso();

			Period diff = Period.between(ingreso, LocalDate.now());

			if (diff.getMonths() < 14) {
				flag = true;
			}

		}

		String estatus = flag ? "Rechazado" : "En Proceso";

		creditoEntity.setEstatus(estatus);
		String idCredito = Instant.now().toEpochMilli() + creditoEntity.getUsuarioEntity().getRfc()
				+ creditoEntity.getTipoCreditoEntity().getIdTipoCredito();

		creditoEntity.setIdCredito(idCredito);

		CreditoEntity creditoEntity2 = creditoRepository.save(creditoEntity);

		return MapperHelper.map(creditoEntity2, CreditoModel.class);
	}

}
