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
public class BaseExperienceResponse implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -1135771856776633545L;

	private int base_experience;
}
