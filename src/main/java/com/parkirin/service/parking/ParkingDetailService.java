package com.parkirin.service.parking;

import com.parkirin.model.parking.ParkingDetail;
import com.parkirin.model.request.parking.ParkingDetailRequest;

import java.util.List;

public interface ParkingDetailService {
    ParkingDetail register(ParkingDetailRequest parkingDetail);
    List<ParkingDetail> list();
}
