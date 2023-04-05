package com.spring.boot.learning.vams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.learning.vams.model.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer>{
    
}
