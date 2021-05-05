package com.agendagp.api.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Escort implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String age;
    private Double hourCost;
    private String profileImagePath;
    private Boolean status;
    private String cityPlace;

    
    public Escort() {
    }


    public Escort(String id, String name, String age, Double hourCost, String profileImagePath, Boolean status,
            String cityPlace) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hourCost = hourCost;
        this.profileImagePath = profileImagePath;
        this.status = status;
        this.cityPlace = cityPlace;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Escort other = (Escort) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    
    
}
