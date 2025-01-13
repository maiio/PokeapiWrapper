package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PokemonResponseDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 6254582794167135891L;
	
	private int count;
    private String next;
    private String previous;
    private List<PokemonResultDTO> results;

}
