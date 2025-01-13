/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 */
@Data
public class VersionDetail implements Serializable {

	private static final long serialVersionUID = 5026407669363829564L;
	
	private int rarity;
    private Version version;

}
