package com.parkirin.service.vehicle;

import com.parkirin.model.vehicle.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle register(Vehicle vehicle);
    List<Vehicle> viewAll();

    Vehicle spesifictName(String name);
}
