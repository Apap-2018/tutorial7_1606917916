package com.apap.tutorial7.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DealerDetail {

    private String status;

    @JsonProperty("building-license")
    private Integer buildingLicense;

    @JsonProperty("valid-until")
    private Date validuntil;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status =  status;
    }

    public Integer getBuildingLicense() {
        return buildingLicense;
    }

    public void setBuildingLicense(Integer buildingLicense) {
        this.buildingLicense = buildingLicense;
    }

    public Date getValiduntil() {
        return validuntil;
    }

    public void setValiduntil(Date validuntil) {
        this.validuntil = validuntil;
    }
}
