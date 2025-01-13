/**
 * 
 */
package com.bankaya.pokeapiwrapper.adapter.input;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bankaya.pokeapiwrapper.application.dto.AbilityDTO;
import com.bankaya.pokeapiwrapper.application.dto.BaseExperienceResponse;
import com.bankaya.pokeapiwrapper.application.dto.ComplementDTO;
import com.bankaya.pokeapiwrapper.application.dto.HeldItemDTO;
import com.bankaya.pokeapiwrapper.application.dto.NameRequest;
import com.bankaya.pokeapiwrapper.application.locationarea.dto.LocationAreaDTO;
import com.bankaya.pokeapiwrapper.application.service.QueryPokemonService;
import com.bankaya.pokeapiwrapper.infraestructure.utils.DataComplementUtils;

import feign.FeignException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebService(serviceName = "PokeapiWrapperSoapService", 
        targetNamespace = "http://input.adapter.pokeapiwrapper.bankaya.com/")
public class PokeapiWrapperSoap {

	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private QueryPokemonService queryPokemonService;
	/**
	 * Metodo para recuperar abilities.
	 * @param pokemonName - nombre del pokemon.
	 * @return regresa Abilities.
	 * @throws JAXBException 
	 */
	@WebMethod
	public List<AbilityDTO> abilities(@WebParam(name = "name") final NameRequest name) throws JAXBException {
		
		log.info("Nombre de entrada: {} ", name);
		
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		
		List<AbilityDTO> response =  queryPokemonService.getAbilities(complement);
		
		return response;
	}
	
	/**
	 * Metodo para recuperar base_experience.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@WebMethod
	public BaseExperienceResponse base_experience(@WebParam(name = "name") final NameRequest name) throws JAXBException {
		log.info("Nombre de entrada: {}", name.getName());
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return new BaseExperienceResponse(queryPokemonService.getBaseExperience(complement));
	}

	/**
	 * Metodo para recuperar base_experience.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@WebMethod
	public List<HeldItemDTO>  held_items(@WebParam(name = "name")final NameRequest name) throws JAXBException {
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return queryPokemonService.getHeldItems(complement);
	}
	
	/**
	 * Metodo para recuperar base_experience.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@WebMethod
	public int id(@WebParam(name = "name") final NameRequest name) throws JAXBException {
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return queryPokemonService.getId(complement);
	}
	
	/**
	 * Metodo para recuperar base_experience.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@WebMethod
	public String name(@WebParam(name = "name") final NameRequest name) throws FeignException, JAXBException {
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		return queryPokemonService.getName(complement);
	}
	
	/**
	 * Metodo para recuperar base_experience.
	 * @param pokemonName -  nombre del pokemon.
	 * @return regresa base experience.
	 * @throws JAXBException 
	 */
	@WebMethod
	public List<LocationAreaDTO> location_area_encounters(
			            @WebParam(name = "name") final NameRequest name) throws JAXBException {
		ComplementDTO complement = ComplementDTO.builder()
				.nameRequest(name)
				.ip(DataComplementUtils.getIpAddress(request))
				.durationTime(System.currentTimeMillis())
				.build();
		
		return queryPokemonService.getLocationAreaEncounters(complement);
	}

}
