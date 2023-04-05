package com.spring.boot.learning.vams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claim", schema = "vams")
public class Claim {

    @Id
    @Column (name= "claim_id")
    private Integer claimId;

    @Column (name = "description")
    private String description;


    public Claim() {
    }


    public Claim(Integer claimId, String description) {
        this.claimId = claimId;
        this.description = description;
    }


    public Integer getClaimId() {
        return this.claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
            " claimId='" + getClaimId() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }



    
}
