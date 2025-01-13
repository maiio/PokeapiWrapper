/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 */
@Data
@AllArgsConstructor
public class HeldItemDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -8583869292209410922L;

	private List<HeldItem> heldItems;
	
}
