/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author mayolomirandamiranda
 *
 */
@Data
public class ListHeldItemDTO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -648297608254934149L;
	
	private List<HeldItemDTO> listHeldItems;
	
}
