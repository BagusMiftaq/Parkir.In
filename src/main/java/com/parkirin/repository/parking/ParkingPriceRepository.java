package com.parkirin.repository.parking;

import com.parkirin.model.parking.ParkingPrice;
import com.parkirin.model.parking.ParkingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingPriceRepository extends JpaRepository<ParkingPrice, Integer> {
    @Query(value = "select * from parking_price where parking_price_id = ?1", nativeQuery = true)
    ParkingPrice findId(Integer id);
}
