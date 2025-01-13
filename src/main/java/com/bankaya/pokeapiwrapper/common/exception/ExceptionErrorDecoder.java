/**
 * 
 */
package com.bankaya.pokeapiwrapper.common.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * 
 */
public class ExceptionErrorDecoder implements ErrorDecoder {
	@Override
    public Exception decode(String methodKey, Response response) {
        int statusCode = response.status();
        System.out.println("HTTP Status Code: " + statusCode);
        
        if (statusCode == 404) {
            return new NotFoundException("Resource not found");
        } else if (statusCode >= 500) {
            return new ServerException("Server error");
        }
        return new Exception("General error");
    }

}
