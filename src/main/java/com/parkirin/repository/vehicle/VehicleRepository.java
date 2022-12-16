package com.parkirin.repository.vehicle;

import com.parkirin.model.vehicle.Type;
import com.parkirin.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query(value = "select * from vehicle where number_plate = ?1", nativeQuery = true)
    Vehicle spesifictName(String name);
}
