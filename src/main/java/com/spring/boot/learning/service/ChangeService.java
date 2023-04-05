package com.spring.boot.learning.service;

import java.util.List;

import com.spring.boot.learning.event.model.Change;

public interface ChangeService {

    public List<Change> findAll ();
    
}
