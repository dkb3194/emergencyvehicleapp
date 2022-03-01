package com.trainingapps.emergencyvehicleapp.vehiclerequestms.service;

import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.ChangeStatus;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequest;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequestDetails;

public interface IVehicleRequestService {
    VehicleRequestDetails add(VehicleRequest request);

    VehicleRequestDetails findById(long id);

    VehicleRequestDetails changeStatus(ChangeStatus status);

}
