package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 */
@Data
public class PokemonResultDTO implements Serializable {
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -335876820604869161L;
	
	private String name;
    private String url;
	

}
