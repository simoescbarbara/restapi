package com.spring.boot.learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.learning.event.model.Change;
import com.spring.boot.learning.event.repository.ChangeRepository;
import com.spring.boot.learning.service.ChangeService;


@Service
public class ChangeServiceImpl implements ChangeService {

@Autowired
ChangeRepository changeRepository;

public ChangeServiceImpl(ChangeRepository changeRepository){
    this.changeRepository = changeRepository;
}

@Override
public List<Change> findAll(){
    return (List<Change>) changeRepository.findAll();
}
    
}
