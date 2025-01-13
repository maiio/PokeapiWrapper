/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 */
@Data
@AllArgsConstructor
public class NameResponse implements Serializable {

	/**
	 *  Serial version.
	 */
	private static final long serialVersionUID = -3401919531654668160L;
	
	private String name;
}
