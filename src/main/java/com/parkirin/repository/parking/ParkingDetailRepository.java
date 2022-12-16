package com.parkirin.repository.parking;

import com.parkirin.model.parking.ParkingDetail;
import com.parkirin.model.parking.ParkingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingDetailRepository extends JpaRepository<ParkingDetail, Integer> {
    @Query(value = "select * from dtl_parking where parking_id = ?1", nativeQuery = true)
    ParkingDetail findId(Integer id);
}
