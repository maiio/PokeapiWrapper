package com.bankaya.pokeapiwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableFeignClients(basePackages = "com.bankaya.pokeapiwrapper")
public class PokeapiwrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeapiwrapperApplication.class, args);
		log.info("Servicio iniciado correctamente Ene-2025!!");
	}
}
