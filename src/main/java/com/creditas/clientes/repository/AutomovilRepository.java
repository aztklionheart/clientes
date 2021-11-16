package com.creditas.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditas.clientes.entity.AutomovilEntity;

public interface AutomovilRepository extends JpaRepository<AutomovilEntity, Long> {

}
