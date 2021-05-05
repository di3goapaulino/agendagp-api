package com.agendagp.api.dto;

import java.io.Serializable;

import com.agendagp.api.domain.Escort;

public class EscortDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String age;
    private Double hourCost;
    private String profileImagePath;
    private Boolean status;
    private String cityPlace;


    public EscortDTO(){

    }
    
    public EscortDTO(Escort escort) {
        this.id = escort.getId();
        this.name = escort.getName();
        this.age = escort.getAge();
        this.hourCost = escort.getHourCost();
        this.profileImagePath = escort.getProfileImagePath();
        this.status = escort.getStatus();
        this.cityPlace = escort.getCityPlace();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Double getHourCost() {
        return hourCost;
    }
    public void setHourCost(Double hourCost) {
        this.hourCost = hourCost;
    }
    public String getProfileImagePath() {
        return profileImagePath;
    }
    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getCityPlace() {
        return cityPlace;
    }
    public void setCityPlace(String cityPlace) {
        this.cityPlace = cityPlace;
    }
    
}
