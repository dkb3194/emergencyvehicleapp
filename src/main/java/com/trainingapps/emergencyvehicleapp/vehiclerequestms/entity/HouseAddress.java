package com.trainingapps.emergencyvehicleapp.vehiclerequestms.entity;

import javax.persistence.*;

@Table
@Entity
public class HouseAddress {
    @GeneratedValue
    @Id
    Long id;
    String city;
    String street;
    String houseNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
