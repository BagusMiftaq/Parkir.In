package com.parkirin.controller.main;

import com.parkirin.model.parking.ParkingDetail;
import com.parkirin.model.parking.ParkingOut;
import com.parkirin.model.report.ParkingReport;
import com.parkirin.model.request.parking.ParkingDetailRequest;
import com.parkirin.model.request.parking.ParkingOutRequest;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.service.parking.ParkingDetailService;
import com.parkirin.service.parking.ParkingOutService;
import com.parkirin.utils.UrlMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Tag(name = "PARKING")
@RestController
@RequestMapping(UrlMapping.PAR_URL)
public class ParkingController {

    ParkingDetailService parkingDetailService;

    ParkingOutService parkingOutService;

    public ParkingController(ParkingDetailService parkingDetailService, ParkingOutService parkingOutService) {
        this.parkingDetailService = parkingDetailService;
        this.parkingOutService = parkingOutService;
    }

    @PostMapping
    public ResponseEntity registerParking(@RequestBody ParkingDetailRequest input) throws Exception{
        ParkingDetail result  = parkingDetailService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register", result));
    }

    @GetMapping
    public ResponseEntity listParking() throws Exception{
        List<ParkingDetail> result  = parkingDetailService.list();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("List", result));
    }

    @PostMapping(UrlMapping.OUT_URL)
    public ResponseEntity registerOut(@RequestBody ParkingOutRequest input) throws Exception{
        ParkingOut result  = parkingOutService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register", result));
    }

    @GetMapping(UrlMapping.OUT_URL)
    public ResponseEntity listOut() throws Exception{
        List<ParkingOut> result  = parkingOutService.list();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("List", result));
    }

}
