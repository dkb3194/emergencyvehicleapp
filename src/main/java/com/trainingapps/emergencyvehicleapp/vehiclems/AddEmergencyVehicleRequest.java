package com.trainingapps.emergencyvehicleapp.vehiclems;

import com.trainingapps.emergencyvehicleapp.util.VehicleColor;

import javax.validation.constraints.Size;

public class AddEmergencyVehicleRequest {

    Long id;
    @Size(min=2,max=10)
    String vehicleNumber;
    VehicleColor vehicleColor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleColor getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(VehicleColor vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
