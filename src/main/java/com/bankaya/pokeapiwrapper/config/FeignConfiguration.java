/**
 * 
 */
package com.bankaya.pokeapiwrapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bankaya.pokeapiwrapper.common.exception.ExceptionErrorDecoder;

import feign.Logger;

/**
 * 
 */
@Configuration
public class FeignConfiguration {

	@Bean
    ExceptionErrorDecoder errorDecoder() {
        return new ExceptionErrorDecoder();
    }
	
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
