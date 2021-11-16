package com.creditas.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditas.clientes.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
