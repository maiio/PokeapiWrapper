/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.locationarea.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 
 */
@Data
public class LocationAreaDTO implements Serializable {

	/**
	 * Serial version
	 */
    private static final long serialVersionUID = -5796887555468408547L;
	private LocationArea location_area;
    private List<VersionLocDetail> version_details;
    
}
