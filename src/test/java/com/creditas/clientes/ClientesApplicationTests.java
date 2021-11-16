package com.creditas.clientes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.creditas.clientes.model.CodigoPostalModel;
import com.creditas.clientes.service.CodigoPostalService;

@SpringBootTest
class ClientesApplicationTests {
	
	@Autowired
	CodigoPostalService codigoPostalService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCodigoPostal() {
		
		String codigoPostal = "54150";
		
		CodigoPostalModel codigoPostalModel = codigoPostalService.obtieneColonias(codigoPostal);
		
		Assert.notNull(codigoPostalModel, "Exito!");
		
	}

}
