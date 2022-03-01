package com.trainingapps.emergencyvehicleapp.vehiclerequestms.controller;


import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.ChangeStatus;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequest;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.dto.VehicleRequestDetails;
import com.trainingapps.emergencyvehicleapp.vehiclerequestms.service.IVehicleRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicleRequest")
@RestController
public class VehicleRequestController {

    @Autowired
    private IVehicleRequestService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public VehicleRequestDetails add(@RequestBody VehicleRequest request){

        return service.add(request);
    }


    @GetMapping("/{id}")
    VehicleRequestDetails findRequestDetailsById(@PathVariable long Id)
    {

        return service.findById(Id);
    }


    @PutMapping("/changestatus")
    public VehicleRequestDetails changeStatus(ChangeStatus request) throws Exception {
        return service.changeStatus(request);
    }

}
