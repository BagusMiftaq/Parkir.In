package com.parkirin.service.parking;

import com.parkirin.model.parking.Area;
import com.parkirin.model.parking.ParkingType;
import com.parkirin.model.request.parking.ParkingTypeRequest;

import java.util.List;

public interface ParkingTypeService {
   ParkingType register(ParkingTypeRequest parkingType);
    List<ParkingType> viewAll();
    ParkingType spesificName(String name);
}
