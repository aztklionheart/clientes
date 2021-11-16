package com.creditas.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.creditas.clientes.entity.CreditoEntity;

public interface CreditoRepository extends JpaRepository<CreditoEntity, String> {

	@Query(value = "Select COUNT(c.*) FROM CREDITO c JOIN USUARIO u ON u.ID_USUARIO = c.ID_USUARIO JOIN TIPO_CREDITO tc ON tc.ID_TIPO_CREDITO = c.ID_TIPO_CREDITO WHERE u.RFC = ?1 AND tc.ID_TIPO_CREDITO = ?2 AND c.ESTATUS = 'Rechazado'", nativeQuery = true)
	public Integer validaRechazado(String rfc, Long idTipoCredito );
	
}
