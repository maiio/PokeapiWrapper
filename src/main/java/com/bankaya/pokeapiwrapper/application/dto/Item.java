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
public class Item implements Serializable {

	private static final long serialVersionUID = -2538977306270458781L;
	
	private String name;
    private String url;

}
