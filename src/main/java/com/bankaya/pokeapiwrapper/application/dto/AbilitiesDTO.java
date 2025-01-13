package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class AbilitiesDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -5419777754321007090L;
	
	private List<AbilityDTO> abilities;

}
