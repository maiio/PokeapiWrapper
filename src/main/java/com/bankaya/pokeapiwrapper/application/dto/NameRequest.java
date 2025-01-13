/**
 * 
 */
package com.bankaya.pokeapiwrapper.application.dto;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 
 */
@Data
@XmlRootElement
public class NameRequest implements Serializable {

	private static final long serialVersionUID = 8044291086891627963L;
	
	private String name;
	
}
