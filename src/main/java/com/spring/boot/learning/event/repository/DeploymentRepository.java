package com.spring.boot.learning.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.learning.event.model.Deployment;

@Repository
public interface DeploymentRepository extends CrudRepository<Deployment, Integer>{

    
}
