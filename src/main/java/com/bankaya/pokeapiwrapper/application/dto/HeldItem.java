/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 
 */
@Data
public class HeldItem implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 197074020558821612L;

	private Item item;

    private List<VersionDetail> version_details;
}
