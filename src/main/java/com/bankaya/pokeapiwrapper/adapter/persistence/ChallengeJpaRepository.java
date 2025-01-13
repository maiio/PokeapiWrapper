/**
 * 
 */
package com.bankaya.pokeapiwrapper.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaya.pokeapiwrapper.entities.ChallengeEntity;

@Repository
public interface ChallengeJpaRepository extends JpaRepository<ChallengeEntity, Long> {
	
}
