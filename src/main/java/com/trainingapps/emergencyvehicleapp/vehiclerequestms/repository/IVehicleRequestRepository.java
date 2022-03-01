package com.trainingapps.emergencyvehicleapp.vehiclerequestms.repository;

import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehicleRequestRepository extends JpaRepository<VehicleRequest, Long> {
    VehicleRequest findById(long id);
}
