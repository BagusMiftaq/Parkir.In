package com.parkirin.controller.support.parking;

import com.parkirin.model.parking.ParkingPrice;
import com.parkirin.model.request.parking.ParkingPriceRequest;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.service.parking.ParkingPriceService;
import com.parkirin.utils.UrlMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.PRI_URL)
public class ParkingPriceController {

    ParkingPriceService parkingPriceService;

    public ParkingPriceController(ParkingPriceService parkingPriceService) {
        this.parkingPriceService = parkingPriceService;
    }

    @PostMapping
    public ResponseEntity registerParkingPrice(@RequestBody ParkingPriceRequest input) throws Exception{
        ParkingPrice result  = parkingPriceService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register an ParkingPrice", result));
    }

    @GetMapping
    public ResponseEntity listParkingPrice() throws Exception{
        List<ParkingPrice> result  = parkingPriceService.viewAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("ParkingPrice List", result));
    }
}
