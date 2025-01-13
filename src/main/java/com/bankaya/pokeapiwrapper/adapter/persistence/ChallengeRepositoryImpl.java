package com.bankaya.pokeapiwrapper.adapter.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaya.pokeapiwrapper.entities.ChallengeEntity;

@Service
public class ChallengeRepositoryImpl implements ChallengeRepository {

	@Autowired
	private ChallengeJpaRepository challengeJpaRepository;

    @Override
    public ChallengeEntity registerRequest(ChallengeEntity challengeEntity) {
        return challengeJpaRepository.save(challengeEntity);
    }
    
}
