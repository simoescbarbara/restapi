package com.spring.boot.learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.learning.service.ClaimService;
import com.spring.boot.learning.vams.model.Claim;
import com.spring.boot.learning.vams.repository.ClaimRepository;


@Service
public class ClaimServiceImpl implements ClaimService {

@Autowired
ClaimRepository claimRepository;

public ClaimServiceImpl(ClaimRepository claimRepository){
    this.claimRepository = claimRepository;
}

@Override
public List<Claim> findAll(){
    return (List<Claim>) claimRepository.findAll();
}
    
}
