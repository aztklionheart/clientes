package com.creditas.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditas.clientes.entity.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

	List<EmpresaEntity> findByNombreEmpresaLikeIgnoreCase(String nombreEmpresa);
}
