package com.spring.boot.learning.service;

import java.util.List;

import com.spring.boot.learning.vams.model.Claim;

public interface ClaimService {

    public List<Claim> findAll ();
    
}
