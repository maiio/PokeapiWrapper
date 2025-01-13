/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.service;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaya.pokeapiwrapper.adapter.persistence.ChallengeRepository;
import com.bankaya.pokeapiwrapper.application.dto.AbilitiesDTO;
import com.bankaya.pokeapiwrapper.application.dto.AbilityDTO;
import com.bankaya.pokeapiwrapper.application.dto.ComplementDTO;
import com.bankaya.pokeapiwrapper.application.dto.HeldItemDTO;
import com.bankaya.pokeapiwrapper.application.dto.ListHeldItemDTO;
import com.bankaya.pokeapiwrapper.application.dto.ListLocationAreaDTO;
import com.bankaya.pokeapiwrapper.application.dto.NameRequest;
import com.bankaya.pokeapiwrapper.application.dto.PokemonResponseDTO;
import com.bankaya.pokeapiwrapper.application.dto.PokemonSpecificationDTO;
import com.bankaya.pokeapiwrapper.application.locationarea.dto.LocationAreaDTO;
import com.bankaya.pokeapiwrapper.entities.ChallengeEntity;
import com.bankaya.pokeapiwrapper.infraestructure.client.PokeapiWrapperClient;
import feign.FeignException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

/**
 * Bussiness logic to return some features.
 */
@Slf4j
@Service
public class QueryPokemonService {
	
	@Autowired
	private PokeapiWrapperClient pokerapiWrapperClient;
	
	@Autowired
	private ChallengeRepository challengeRepository;
	
	public PokemonResponseDTO getPokemon() {
		log.info("getPokemon()");
		PokemonResponseDTO response = pokerapiWrapperClient.getPokemon();
	    response.getResults().forEach(result -> 
	                          log.info("Name: {}  URL: {}", result.getName(), result.getUrl()));
	    return response;
	}
	
	public List<AbilityDTO> getAbilities(final ComplementDTO complement) throws JAXBException {

		
	    PokemonSpecificationDTO response = pokerapiWrapperClient.getPokemon(
	    		complement.getNameRequest().getName());
	    
	    registryData("abilities", complement, response);
	    
	    response.getAbilities().forEach(ability -> 
        log.info("AbilityName: {}  URL: {}", ability.getAbility().getName(), ability.getAbility().getUrl()));

	    return response.getAbilities();
	}
	
	public int getBaseExperience(final ComplementDTO complement)  throws JAXBException {
	    PokemonSpecificationDTO response = pokerapiWrapperClient.getPokemon(complement.getNameRequest().getName());
	    registryData("base_experience", complement, response);
	    log.info("baseExperience: {} ", response.getBase_experience());
	    return response.getBase_experience();
	}
	
	public List<HeldItemDTO> getHeldItems(final ComplementDTO complement)  throws JAXBException {
	    PokemonSpecificationDTO response = pokerapiWrapperClient.getPokemon(complement.getNameRequest().getName());
	    registryData("held_items", complement, response);
	    log.info("getHeldItems: {} ", response.getHeld_items());
	    response.getHeld_items().forEach(heldItem -> 
                                log.info("heldItem: {}  URL: {}", heldItem.getHeldItems().toString()));
	    return response.getHeld_items();
	}
	
	public int getId(final ComplementDTO complement) throws JAXBException  {
	    PokemonSpecificationDTO response = pokerapiWrapperClient.getPokemon(complement.getNameRequest().getName());
	    registryData("id", complement, response);
	    log.info("getId: {} ", response.getId());
	    return response.getId();
	}
	
	public String getName(final ComplementDTO complement)  throws JAXBException {
		PokemonSpecificationDTO response = null;
		try {
			response = pokerapiWrapperClient.getPokemon(complement.getNameRequest().getName());
			registryData("name", complement, response);
		} catch(FeignException fe) {
			log.info("Name {} not found! Httpcode: {}", complement.getNameRequest().getName(),  fe.status());
			throw fe;
		}
	    
	    return complement.getNameRequest().getName();
	}
	
	public List<LocationAreaDTO> getLocationAreaEncounters(final ComplementDTO complement)  throws JAXBException {
		PokemonSpecificationDTO response = new PokemonSpecificationDTO();
		response.setLocation_area_encounters(pokerapiWrapperClient.getPokemon(this.getId(complement)));
		
		registryData("location_area_encounters", complement, response);
	    return response.getLocation_area_encounters();
	}
	

	private void registryData(final String methodName, 
			final ComplementDTO complement, PokemonSpecificationDTO response) throws JAXBException {
		
		ChallengeEntity challengeEntity = new ChallengeEntity();
		challengeEntity.setIpOrigin(complement.getIp());
	    challengeEntity.setRequestDate(new Date());
	    challengeEntity.setExecuteMethod(methodName);
	    
	    JAXBContext context = JAXBContext.newInstance(NameRequest.class);
        Marshaller marshaller = context.createMarshaller();
        // Convertir el objeto a XML
        StringWriter writer = new StringWriter();
        marshaller.marshal(complement.getNameRequest(), writer);

        log.info(writer.toString());
	    challengeEntity.setRequest(writer.toString());
	    
	    StringWriter writerResponse = new StringWriter();
	    
		switch(methodName) {
			case "abilities":
				context = JAXBContext.newInstance(AbilitiesDTO.class);
			    marshaller = context.createMarshaller();
			    
			    AbilitiesDTO abilities = new AbilitiesDTO();
			    abilities.setAbilities(response.getAbilities());
			    marshaller.marshal(abilities, writerResponse);
				break;
			case "base_experience":
				context = JAXBContext.newInstance(Integer.class);
				marshaller = context.createMarshaller();
				marshaller.marshal(response.getBase_experience(), writerResponse);
				break;
			case "held_items":
				context = JAXBContext.newInstance(ListHeldItemDTO.class);
				marshaller = context.createMarshaller();
				marshaller.marshal(response.getHeld_items(), writerResponse);
				break;
			case "id":
				context = JAXBContext.newInstance(Integer.class);
				marshaller = context.createMarshaller();
				marshaller.marshal(response.getId(), writerResponse);
				break;
			case "name":
				context = JAXBContext.newInstance(String.class);
				marshaller = context.createMarshaller();
				marshaller.marshal(response.getName(), writerResponse);
				break;
			case "location_area_encounters":
				context = JAXBContext.newInstance(ListLocationAreaDTO.class);
				marshaller = context.createMarshaller();
				marshaller.marshal(response.getLocation_area_encounters(), writerResponse);
				break;
			default:
				log.info("pokemon default");
		}
		
	    challengeEntity.setResponse(writerResponse.toString());
	    challengeEntity.setTime(System.currentTimeMillis() - complement.getDurationTime());
	    challengeRepository.registerRequest(challengeEntity);
	}

}
