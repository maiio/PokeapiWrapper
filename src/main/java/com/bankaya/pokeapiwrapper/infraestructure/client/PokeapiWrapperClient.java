/**
 * 
 */
package com.bankaya.pokeapiwrapper.infraestructure.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bankaya.pokeapiwrapper.application.dto.PokemonResponseDTO;
import com.bankaya.pokeapiwrapper.application.dto.PokemonSpecificationDTO;
import com.bankaya.pokeapiwrapper.application.locationarea.dto.LocationAreaDTO;

/**
 * Define client to challenge.
 */
@FeignClient(name = "pokeapiClient", url = "${pokeapi.client.url}") 
public interface PokeapiWrapperClient {
	
	@GetMapping("/pokemon")
    public PokemonResponseDTO getPokemon();
	
	@GetMapping("/pokemon/{name}")
    public PokemonSpecificationDTO getPokemon(@PathVariable("name") String name);
	
	@GetMapping("/pokemon/{id}/encounters")
    public List<LocationAreaDTO> getPokemon(@PathVariable("id") int id);

}
