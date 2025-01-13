/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.locationarea.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 */
@Data
public class Method implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 8037369951642900080L;
	
	private String name;
	private String url;

}
