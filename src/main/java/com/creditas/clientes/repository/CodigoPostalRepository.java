package com.creditas.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.creditas.clientes.entity.CodigoPostalEntity;

public interface CodigoPostalRepository extends JpaRepository<CodigoPostalEntity, Long> {

	List<CodigoPostalEntity> findByCodigoPostal(String codigoPostal);

	@Query(value = "Select m.NOMBRE_MUNICIPIO FROM CP cp JOIN MUNICIPIO m ON cp.ID_MUNICIPIO = m.ID_MUNICIPIO WHERE cp.CODIGO_POSTAL = ?1", nativeQuery = true)
	String findMuinicipioByCodigoPostal(String codigoPostal);

	@Query(value = "Select e.NOMBRE_ESTADO FROM CP cp JOIN MUNICIPIO m ON cp.ID_MUNICIPIO = m.ID_MUNICIPIO JOIN ESTADO e ON e.ID_ESTADO = m.ID_ESTADO WHERE cp.CODIGO_POSTAL = ?1", nativeQuery = true)
	String findEstadoByCodigoPostal(String codigoPostal);

	@Query(value = "Select e.NOMBRE_ESTADO FROM CP cp JOIN MUNICIPIO m ON cp.ID_MUNICIPIO = m.ID_MUNICIPIO JOIN ESTADO e ON e.ID_ESTADO = m.ID_ESTADO WHERE cp.CODIGO_POSTAL = ?1 AND e.ID_ESTADO IN (9,15)", nativeQuery = true)
	String validaDomicilio(String cp);

}
