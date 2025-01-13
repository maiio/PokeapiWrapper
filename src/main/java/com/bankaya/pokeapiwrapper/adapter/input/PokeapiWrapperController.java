package com.bankaya.pokeapiwrapper.adapter.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankaya.pokeapiwrapper.application.service.QueryPokemonService;
import com.bankaya.pokeapiwrapper.infraestructure.utils.DataComplementUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import com.bankaya.pokeapiwrapper.application.dto.*;
import com.bankaya.pokeapiwrapper.application.locationarea.dto.LocationAreaDTO;

/**
 * Controlador para Abilities.
 */
@Slf4j
@Tag(name = "Consulta de Ablities.")
@CrossOrigin
@RestController
@RequestMapping("/")
public class PokeapiWrapperController {
	
	@Autowired
	private QueryPokemonService queryPokemonService;
	
	@Autowired
    private HttpServletRequest request;
	
	/**
	 * Metodo para recuperar abilities.
	 * @param pokemonName - nombre del pokemon.
	 * @return regresa Abilities.
	 * @throws JAXBException 
	 */
	@Operation(summary = "Method to get abilities.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Abilities list."),
					@ApiResponse(responseCode = "400", description = "exception system.")
			})
	@GetMapping("/abilities/{name}")
	public List<AbilityDTO> abilities(
			@Parameter(name = "name", description = "pokemon name", required = true)
			@NonNull @PathVariable(name = "name") final NameRequest name) throws JAXBException {
		log.info("Nombre de entrada: {}", name);
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		List<AbilityDTO> response =  queryPokemonService.getAbilities(complement);
		
		for (AbilityDTO ability : response) {
			log.info("ability: {}", ability.getAbility().toString());
		}
		return response;
	}
	
	/**
	 * Metodo para recuperar base_experience.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@Operation(summary = "Method to get base experience.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Base experience."),
					@ApiResponse(responseCode = "400", description = "exception system.")
			})
	@GetMapping(value = "/base_experience/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseExperienceResponse base_experience(@Parameter(name = "name", description = "pokemon name", required = true)
	@NonNull @PathVariable(name = "name") final NameRequest name) throws JAXBException {

		log.info("Nombre de entrada: {}", name.getName());
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return new BaseExperienceResponse(queryPokemonService.getBaseExperience(complement));
	}

	/**
	 * Metodo para recuperar held items.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa lista de held_items.
	 * @throws JAXBException 
	 */
	@Operation(summary = "Method to get held items.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Held item list."),
					@ApiResponse(responseCode = "400", description = "exception system.")
			})
	@GetMapping(value = "/held_items/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HeldItemDTO>  held_items(@Parameter(name = "name", description = "pokemon name", required = true)
	@NonNull @PathVariable(name = "name") final NameRequest name) throws JAXBException {
		
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return queryPokemonService.getHeldItems(complement);
	}
	
	/**
	 * Metodo para recuperar pokemon id.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa el ide del pokemon.
	 * @throws JAXBException 
	 */
	@Operation(summary = "Method to get pokemon id.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Pokemon id."),
					@ApiResponse(responseCode = "400", description = "exception system.")
			})
	@GetMapping(value = "/id/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int id(@Parameter(name = "name", description = "pokemon name", required = true)
	@NonNull @PathVariable(name = "name") final NameRequest name) throws JAXBException {
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return queryPokemonService.getId(complement);
	}
	
	/**
	 * Metodo para recuperar pokemon name.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa nombre del pokemon.
	 * @throws JAXBException 
	 */
	@Operation(summary = "Method to get pokemon name.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Get Pokemon name."),
					@ApiResponse(responseCode = "400", description = "exception system.")
			})
	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String name(@Parameter(name = "name", description = "pokemon name", required = true)
	@NonNull @PathVariable(name = "name") final NameRequest name) throws JAXBException {
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return queryPokemonService.getName(complement);
	}
	
	/**
	 * Metodo para recuperar location_area_encounters.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@Operation(summary = "Method to get location areas.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Location Area encounter list."),
					@ApiResponse(responseCode = "400", description = "exception system.")
			})
	@GetMapping(value = "/location_area_encounters/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LocationAreaDTO> location_area_encounters(@Parameter(name = "name", description = "pokemon name", required = true)
	@NonNull @PathVariable(name = "name") final NameRequest name) throws JAXBException {
		
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		
		return queryPokemonService.getLocationAreaEncounters(complement);
	}
}
