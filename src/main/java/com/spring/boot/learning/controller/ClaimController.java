package com.spring.boot.learning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.learning.service.ClaimService;
import com.spring.boot.learning.vams.model.Claim;

@RestController
@RequestMapping("/api2")
public class ClaimController{

    private ClaimService claimService;

    public ClaimController(ClaimService claimService){
        this.claimService = claimService;
    }
   
    @GetMapping("/claim")
    public List<Claim> findAll(){
        return claimService.findAll();
    }
}