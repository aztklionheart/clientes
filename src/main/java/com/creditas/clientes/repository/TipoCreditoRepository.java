package com.creditas.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditas.clientes.entity.TipoCreditoEntity;

public interface TipoCreditoRepository extends JpaRepository<TipoCreditoEntity, Long> {

}
