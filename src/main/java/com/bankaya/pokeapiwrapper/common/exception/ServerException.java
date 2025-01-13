/**
 * 
 */
package com.bankaya.pokeapiwrapper.common.exception;

/**
 * 
 */
public class ServerException extends RuntimeException {

	private static final long serialVersionUID = 8304376545112304942L;

	public ServerException(String message) {
        super(message);
    }
    
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
