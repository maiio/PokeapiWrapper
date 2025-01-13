package com.bankaya.pokeapiwrapper.application.locationarea.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class EncounterDetail implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -9192147750964983764L;

	private int chance;
	private List<Object> condition_values;
	private int max_level;
	private Method method;
	private int min_level;

}
