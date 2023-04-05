package com.spring.boot.learning.event.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "incident", schema = "events")
public class Incident {

    @Id
    @GeneratedValue
    @Column (name = "incident_id")
    private Integer id;

    @Column (name = "number")
    private String incidentNumber;

    @Column (name = "created_at" )
    private Timestamp createdAt;

    @Column (name = "closed_at")
    private Timestamp closedAt;

    @OneToOne
    private Deployment deploy;


    public Incident() {
    }


    public Incident(Integer id, String incidentNumber, Timestamp createdAt, Timestamp closedAt, Deployment deploy) {
        this.id = id;
        this.incidentNumber = incidentNumber;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.deploy = deploy;
    }


    public String getIncidentNumber() {
        return this.incidentNumber;
    }

    public void setIncidentNumber(String incidentNumber) {
        this.incidentNumber = incidentNumber;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getClosedAt() {
        return this.closedAt;
    }

    public void setClosedAt(Timestamp closedAt) {
        this.closedAt = closedAt;
    }


    public Deployment getDeploy() {
        return this.deploy;
    }

    public void setDeploy(Deployment deploy) {
        this.deploy = deploy;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", incidentNumber='" + getIncidentNumber() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", closedAt='" + getClosedAt() + "'" +
            ", deployId='" + getDeploy() + "'" +
            "}";
    }



}
