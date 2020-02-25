package com.ecommerce.microcommerce.exception;

public class CategorieNontrouvableException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public CategorieNontrouvableException(String message) {
		super(message) ;
	}

}
