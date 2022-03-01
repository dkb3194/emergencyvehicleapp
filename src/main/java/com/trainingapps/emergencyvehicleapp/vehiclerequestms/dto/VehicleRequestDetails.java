package com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto;

import com.trainingapps.emergencyvehicleapp.util.RequestStatus;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.entity.HouseAddress;

import java.util.Objects;

public class VehicleRequestDetails {

    Long id ;
    HouseAddress address ;
    String pincode;
    String phoneNumber;
    RequestStatus requestStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HouseAddress getAddress() {
        return address;
    }

    public void setAddress(HouseAddress address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleRequestDetails that = (VehicleRequestDetails) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
