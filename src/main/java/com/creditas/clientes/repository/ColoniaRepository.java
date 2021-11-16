package com.creditas.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.creditas.clientes.entity.ColoniaEntity;

public interface ColoniaRepository extends JpaRepository<ColoniaEntity, Long> {

	@Query(value = "SELECT c.* FROM COLONIA c JOIN CP cp ON c.codigo_postal = cp.codigo_postal WHERE c.codigo_postal=?1", nativeQuery = true)
	List<ColoniaEntity> buscaPorCP(String cp);

}
