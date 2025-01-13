/**
 * 
 */
package com.bankaya.pokeapiwrapper.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bankaya.pokeapiwrapper.adapter.input.PokeapiWrapperSoap;

import jakarta.xml.ws.Endpoint;

/**
 * 
 */
@Configuration
public class WsSoapConfiguration {
	
	@Bean
    public Endpoint endpoint(Bus bus, PokeapiWrapperSoap pokeapiWrapperSoap) {
        EndpointImpl endpoint = new EndpointImpl(bus, pokeapiWrapperSoap);
        endpoint.publish("/PokeapiWrapperSoapService");
        return endpoint;
    }

    @Bean
    public PokeapiWrapperSoap pokeapiWrapperSoap() {
        return new PokeapiWrapperSoap();
    }

}
