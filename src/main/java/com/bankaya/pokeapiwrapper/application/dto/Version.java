/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 */
@Data
public class Version implements Serializable {

	private static final long serialVersionUID = -4045696707471309307L;

	private String name;
    private String url;
	
}
