package com.parkirin.service.parking;

import com.parkirin.model.parking.ParkingOut;
import com.parkirin.model.report.ParkingReport;
import com.parkirin.model.request.parking.ParkingOutRequest;

import java.util.Date;
import java.util.List;

public interface ParkingOutService {
    ParkingOut register(ParkingOutRequest parkingOut);
    List<ParkingOut> list();
    List<ParkingReport> showReport();
    List<ParkingReport> showReportByDay(String day);

    List<ParkingReport> showReportByMonth(Integer month, Integer year);
}
