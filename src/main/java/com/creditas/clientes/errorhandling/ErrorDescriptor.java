package com.creditas.clientes.errorhandling;

import lombok.Data;

@Data
public class ErrorDescriptor {

	private long timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

}
