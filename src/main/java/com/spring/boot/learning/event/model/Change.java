package com.spring.boot.learning.event.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "change", schema = "events")
public class Change {
    
    @Id
    @Column (name = "change_id")
    private Integer id;

    @Column (name = "source")
    private String source;

    @Column (name = "event_type")
    private String type;

    @Column (name = "time_creation")
    private Timestamp timeCreation;

    @Column (name = "metadata")
    private String metadata;

    @ManyToOne(optional = true, cascade = CascadeType.MERGE)
    @JoinColumn(name = "deploy_id")
    @JsonBackReference
    private Deployment deployment;


    public Change() {
    }


    public Change(Integer id, String source, String type, Timestamp timeCreation, String metadata, Deployment deployment) {
        this.id = id;
        this.source = source;
        this.type = type;
        this.timeCreation = timeCreation;
        this.metadata = metadata;
        this.deployment = deployment;
    }   


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTimeCreation() {
        return this.timeCreation;
    }

    public void setTimeCreation(Timestamp timeCreation) {
        this.timeCreation = timeCreation;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Deployment getDeployment() {
        return this.deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", source='" + getSource() + "'" +
            ", type='" + getType() + "'" +
            ", timeCreation='" + getTimeCreation() + "'" +
            ", metadata='" + getMetadata() + "'" +
            ", deployment='" + getDeployment() + "'" +
            "}";
    }    


}
