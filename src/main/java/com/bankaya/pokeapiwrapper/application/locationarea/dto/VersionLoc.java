package com.bankaya.pokeapiwrapper.application.locationarea.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class VersionLoc implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 2749261480591975251L;

	private String name;
	private String url;

}
