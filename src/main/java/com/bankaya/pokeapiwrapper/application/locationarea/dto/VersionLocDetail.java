package com.bankaya.pokeapiwrapper.application.locationarea.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class VersionLocDetail implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 8537877480514524060L;

	private List<EncounterDetail> encounter_details;
	private int maxChance;
	private VersionLoc version;

}
