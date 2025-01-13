/**
 * 
 */
package com.bankaya.pokeapiwrapper.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API REST and SOAP",
        description = "API provides REST and SOAP Pokemon services.",
        version = "1.0.0",
        contact = @Contact(name = "Mayolo Miranda Miranda", email = "mayolo.miranda@gmail.com")
    ),
    servers = {
        @Server(url = "http://localhost:8080/", description = "REST Services"),
        @Server(url = "http://localhost:8080/", description = "SOAP Services")
    }
)
public class SwaggerConfiguration {

}
