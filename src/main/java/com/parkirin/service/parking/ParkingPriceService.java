package com.parkirin.service.parking;

import com.parkirin.model.parking.ParkingPrice;
import com.parkirin.model.parking.ParkingType;
import com.parkirin.model.request.parking.ParkingPriceRequest;

import java.util.List;

public interface ParkingPriceService {
    ParkingPrice register(ParkingPriceRequest parkingPrice);
    List<ParkingPrice> viewAll();
}
