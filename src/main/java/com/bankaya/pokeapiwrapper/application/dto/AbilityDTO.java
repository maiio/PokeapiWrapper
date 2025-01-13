/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AbilityDTO implements Serializable {
	
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 2996623615219535480L;
	
	private AbilityDetailDTO ability;
    private boolean is_hidden;
    private int slot;
}
