package com.creditas.clientes.errorhandling;

public class NoContentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7883283395096400811L;

	public NoContentException() {
		super("");
	}

	public NoContentException(Throwable throwable) {
		super(throwable);
	}

}
