/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * 
 */
@Builder
@Data
public class ComplementDTO implements Serializable {
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 7919947232635563640L;
	private NameRequest nameRequest;
	private String ip;
	private long durationTime;

}
