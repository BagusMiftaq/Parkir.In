package com.parkirin.controller.main;

import com.parkirin.model.owner.Owner;
import com.parkirin.model.request.owner.OwnerRequest;
import com.parkirin.model.request.vehicle.VehicleDetailRequest;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.model.vehicle.VehicleDetail;
import com.parkirin.service.vehicle.VehicleDetailService;
import com.parkirin.utils.UrlMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "VEHICLE")
@RestController
@RequestMapping(UrlMapping.VEH_URL)
public class VehicleController {
    VehicleDetailService vehicleDetailService;

    public VehicleController(VehicleDetailService vehicleDetailService) {
        this.vehicleDetailService = vehicleDetailService;
    }

    @PostMapping
    public ResponseEntity registerVehicle(@RequestBody VehicleDetailRequest input) throws Exception{
        VehicleDetail result  = vehicleDetailService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register an owner", result));
    }

    @GetMapping
    public ResponseEntity listOwner() throws Exception{
        List<VehicleDetail> result  = vehicleDetailService.viewAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Vehicle List", result));
    }
}
