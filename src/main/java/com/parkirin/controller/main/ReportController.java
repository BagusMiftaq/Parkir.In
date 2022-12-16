package com.parkirin.controller.main;

import com.parkirin.model.report.ParkingReport;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.service.parking.ParkingDetailService;
import com.parkirin.service.parking.ParkingOutService;
import com.parkirin.utils.UrlMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "REPORT")
@RestController
@RequestMapping("/report")
public class ReportController {

    ParkingDetailService parkingDetailService;

    ParkingOutService parkingOutService;

    public ReportController(ParkingDetailService parkingDetailService, ParkingOutService parkingOutService) {
        this.parkingDetailService = parkingDetailService;
        this.parkingOutService = parkingOutService;
    }

    @GetMapping()
    public ResponseEntity getReport(){
        List<ParkingReport> result = parkingOutService.showReport();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Get All Transaction", result));
    }

    @GetMapping("/monthly")
    public ResponseEntity getReportMonth(@RequestParam Integer month, @RequestParam Integer year){
        List<ParkingReport> result = parkingOutService.showReportByMonth(month, year);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Get All Transaction", result));
    }

    @GetMapping("/daily")
    public ResponseEntity getReportDay(@RequestParam String day){
        List<ParkingReport> result = parkingOutService.showReportByDay(day);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Get All Transaction", result));
    }
}
