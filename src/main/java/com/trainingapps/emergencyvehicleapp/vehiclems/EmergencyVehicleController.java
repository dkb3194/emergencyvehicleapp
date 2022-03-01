package com.trainingapps.emergencyvehicleapp.vehiclems;

import com.trainingapps.emergencyvehicleapp.exception.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/emergencyVehicle")
@RestController
public class EmergencyVehicleController {

    @Autowired
   private IEmergencyVehicleService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public EmergencyVehicleDetails add(@RequestBody @NotNull AddEmergencyVehicleRequest request)
    {
        EmergencyVehicleDetails response = service.add(request);
        return response;
    }

    @GetMapping("/vehicleNumber/{vehicleNumber}")
    public List<EmergencyVehicleDetails> findByVehicleNumber(@PathVariable @NotBlank String vehicleNumber)
    {
        return service.findVehicleDetailsByVehicleNumber(vehicleNumber);
    }

   @PutMapping("/update")
    public EmergencyVehicleDetails updateEmergencyVehicleDetails(@RequestBody @NotNull UpdateVehicle request) throws VehicleNotFoundException
   {
       EmergencyVehicleDetails response = service.update(request);
       return response;
   }
}
