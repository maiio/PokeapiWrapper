package com.bankaya.pokeapiwrapper.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity(name = "challenge")
public class ChallengeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChallenge;
	private String ipOrigin;
	private Date requestDate;
	private String executeMethod;
	private Long time;
	private String request;
	@Lob 
    @Column(columnDefinition = "TEXT")
	private String response;

}
