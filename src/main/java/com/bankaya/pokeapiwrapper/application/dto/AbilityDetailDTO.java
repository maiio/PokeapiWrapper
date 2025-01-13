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
public class AbilityDetailDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -395175525543768396L;
	
	private String name;
    private String url;

}
