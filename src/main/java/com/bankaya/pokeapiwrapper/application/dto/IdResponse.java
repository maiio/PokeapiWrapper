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
public class IdResponse implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -8166997378949195630L;

	private int id;
}
