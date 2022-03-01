package com.trainingapps.emergencyvehicleapp.vehiclems;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEmergencyVehicleRepository extends JpaRepository<EmergencyVehicle,Long> {

    List<EmergencyVehicle> findByVehicleNumber(String vehicleNumber);
}

