package com.trainingapps.emergencyvehicleapp.vehiclerequestms.service;

import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.ChangeStatus;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequest;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequestDetails;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.entity.HouseAddress;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.repository.IVehicleRequestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleRequestServiceImpl implements IVehicleRequestService{
    VehicleRequest requestObj;
    @Autowired
    private IVehicleRequestRepository repo;
    @Override
    public VehicleRequestDetails add(VehicleRequest request) {
        requestObj = new VehicleRequest();
        requestObj.setPincode(request.getPincode());
        requestObj.setPhoneNumber(request.getPhoneNumber());
        HouseAddress houseAddress = new HouseAddress();
        houseAddress.setHouseNumber(request.getAddress().getHouseNumber());
        houseAddress.setCity(request.getAddress().getCity());
        houseAddress.setStreet(request.getAddress().getStreet());
        requestObj.setAddress(houseAddress);
        requestObj.setRequestStatus(request.getRequestStatus());
        requestObj = repo.save(requestObj);

        VehicleRequestDetails vehicleDetail = new VehicleRequestDetails();
        BeanUtils.copyProperties(requestObj,vehicleDetail);
        return vehicleDetail;
    }

    @Override
    public VehicleRequestDetails findById(long id) {
        requestObj = new VehicleRequest();
        requestObj = repo.findById(id);
        VehicleRequestDetails vehicleDetail = new VehicleRequestDetails();
        BeanUtils.copyProperties(requestObj,vehicleDetail);
        return vehicleDetail;
    }

    @Override
    public VehicleRequestDetails changeStatus(ChangeStatus status) {
        VehicleRequest vQ = new VehicleRequest();
        BeanUtils.copyProperties(status,vQ);
        boolean exists = repo.existsById(vQ.getId());
        if (!exists) {
            throw new RuntimeException("Vehicle Not Found");
        }
        vQ = repo.save(vQ);
        VehicleRequestDetails vehicleRequestDetails = new VehicleRequestDetails();
        BeanUtils.copyProperties(vQ,vehicleRequestDetails);
        return vehicleRequestDetails;
    }
}
