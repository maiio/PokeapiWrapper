package com.bankaya.pokeapiwrapper.common.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -1589807525028575331L;
	
	public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
