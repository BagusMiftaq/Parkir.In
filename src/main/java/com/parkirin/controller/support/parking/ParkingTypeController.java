package com.parkirin.controller.support.parking;

import com.parkirin.model.parking.Area;
import com.parkirin.model.parking.ParkingType;
import com.parkirin.model.request.parking.ParkingTypeRequest;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.service.parking.ParkingTypeService;
import com.parkirin.utils.UrlMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.PT_URL)
public class ParkingTypeController {

    ParkingTypeService parkingTypeService;

    public ParkingTypeController(ParkingTypeService parkingTypeService) {
        this.parkingTypeService = parkingTypeService;
    }

    @PostMapping
    public ResponseEntity registerParkingType(@RequestBody ParkingTypeRequest input) throws Exception{
        ParkingType result  = parkingTypeService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register a parking type", result));
    }

    @GetMapping
    public ResponseEntity listParkingType() throws Exception{
        List<ParkingType> result  = parkingTypeService.viewAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Parking Type List", result));
    }
}
