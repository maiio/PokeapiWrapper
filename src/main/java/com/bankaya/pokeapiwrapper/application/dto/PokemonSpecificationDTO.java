/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokeapiwrapper.application.locationarea.dto.LocationAreaDTO;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 
 */
@Data
@XmlRootElement
public class PokemonSpecificationDTO implements Serializable {
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -822625390719352170L;
	
	private List<AbilityDTO> abilities;
    private int base_experience;
    private List<HeldItemDTO> held_items;
    private int id;
    private String name;
    private List<LocationAreaDTO> location_area_encounters;
}
