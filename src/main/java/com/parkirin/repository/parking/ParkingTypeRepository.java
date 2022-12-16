package com.parkirin.repository.parking;

import com.parkirin.model.parking.Area;
import com.parkirin.model.parking.ParkingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingTypeRepository extends JpaRepository<ParkingType, Integer> {

    @Query(value = "select * from parking_type where parking_type_variant = ?1", nativeQuery = true)
    ParkingType spesificName(String name);
}
