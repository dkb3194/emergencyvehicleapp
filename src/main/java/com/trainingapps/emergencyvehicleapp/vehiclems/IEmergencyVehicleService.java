package com.trainingapps.emergencyvehicleapp.vehiclems;

import com.trainingapps.emergencyvehicleapp.exception.VehicleNotFoundException;

import java.util.List;

public interface IEmergencyVehicleService {

    EmergencyVehicleDetails add(AddEmergencyVehicleRequest request);

    List<EmergencyVehicleDetails> findVehicleDetailsByVehicleNumber(String vehicleNumber);

    EmergencyVehicleDetails update(UpdateVehicle request) throws VehicleNotFoundException;;


}
