package com.trainingapps.emergencyvehicleapp.vehiclems;

import com.trainingapps.emergencyvehicleapp.exception.VehicleNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class EmergencyVehicleServiceImpl implements IEmergencyVehicleService{

    @Autowired
    private IEmergencyVehicleRepository repo;


    @Transactional
    @Override
    public EmergencyVehicleDetails add(AddEmergencyVehicleRequest request) {

        EmergencyVehicle emergencyVehicle = new EmergencyVehicle();
        emergencyVehicle.setVehicleNumber(request.getVehicleNumber());
        emergencyVehicle.setVehicleColor(request.getVehicleColor());
        emergencyVehicle = repo.save(emergencyVehicle);

        EmergencyVehicleDetails emergencyVehicleDetails = new EmergencyVehicleDetails();
        emergencyVehicleDetails.setId(emergencyVehicle.getId());
        emergencyVehicleDetails.setVehicleNumber(emergencyVehicle.getVehicleNumber());
        emergencyVehicleDetails.setVehicleColor(emergencyVehicle.getVehicleColor());


        return emergencyVehicleDetails;
    }

    @Override
    public List<EmergencyVehicleDetails> findVehicleDetailsByVehicleNumber(String vehicleNumber) {
        List<EmergencyVehicle> vecileList = repo.findByVehicleNumber(vehicleNumber);
        List<EmergencyVehicleDetails> response = new ArrayList<>();
        for(EmergencyVehicle entry :vecileList)
        {
            EmergencyVehicleDetails emergencyVehicle = new EmergencyVehicleDetails();
            emergencyVehicle.setId(entry.getId());
            emergencyVehicle.setVehicleNumber(entry.getVehicleNumber());
            emergencyVehicle.setVehicleColor(entry.getVehicleColor());
            response.add(emergencyVehicle);
        }

        return response;
    }

    @Override
    public EmergencyVehicleDetails update(UpdateVehicle request) {
        boolean exists = repo.existsById(request.getId());
        if(!exists)
        {
            throw new RuntimeException("vehicle not found");
        }
        EmergencyVehicle vehicle =new EmergencyVehicle();
        BeanUtils.copyProperties(request,vehicle);
        EmergencyVehicle emergencyVehicle = repo.save(vehicle);
        EmergencyVehicleDetails emergencyVehicleDetails=new EmergencyVehicleDetails();
        BeanUtils.copyProperties(emergencyVehicle,emergencyVehicleDetails);
        return emergencyVehicleDetails;
    }
}
