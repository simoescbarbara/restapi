package com.spring.boot.learning.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.learning.event.model.Change;

@Repository
public interface ChangeRepository extends CrudRepository<Change, Integer>{
    
}
