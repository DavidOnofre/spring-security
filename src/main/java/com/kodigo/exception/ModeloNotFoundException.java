package com.kodigo.exception;

public class ModeloNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7854519934103787164L;
	String mensaje;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}