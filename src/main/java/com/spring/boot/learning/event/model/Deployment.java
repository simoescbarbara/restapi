package com.spring.boot.learning.event.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "deployment", schema = "events")
public class Deployment {

    @Id
    @Column (name = "deploy_id")
    private Integer id;

    @Column (name = "time_deployment")
    private Timestamp timeDeployment; 

    @OneToMany(mappedBy = "deployment")
    @JsonManagedReference
    private List<Change> changes;
    

    public Deployment() {
    }


    public Deployment(Integer id, Timestamp timeDeployment, List<Change> changes) {
        this.id = id;
        this.timeDeployment = timeDeployment;
        this.changes = changes;
    }
   

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimeDeployment() {
        return this.timeDeployment;
    }

    public void setTimeDeployment(Timestamp timeDeployment) {
        this.timeDeployment = timeDeployment;
    }

    public List<Change> getChange() {
        return this.changes;
    }

    public void setChange(List<Change> changes) {
        this.changes = changes;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", timeDeployment='" + getTimeDeployment() + "'" +
            ", change='" + getChange() + "'" +
            "}";
    }


}
