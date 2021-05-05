package com.agendagp.api.repository;

import com.agendagp.api.domain.Escort;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscortRepository extends MongoRepository<Escort, String>{
    
}