package com.spring.boot.learning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.learning.event.model.Change;
import com.spring.boot.learning.service.ChangeService;

@RestController
@RequestMapping("/api")
public class ChangeController{

    private ChangeService changeService;

    public ChangeController(ChangeService changeService){
        this.changeService = changeService;
    }
   
    @GetMapping("/changes")
    public List<Change> findAll(){
        return changeService.findAll();
    }
}