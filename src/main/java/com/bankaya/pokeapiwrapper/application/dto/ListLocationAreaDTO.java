/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokeapiwrapper.application.locationarea.dto.LocationAreaDTO;

import lombok.Data;

/**
 * @author mayolomirandamiranda
 *
 */
@Data
public class ListLocationAreaDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 3674860830783534645L;

	private List<LocationAreaDTO> listLocationArea;
	
}
