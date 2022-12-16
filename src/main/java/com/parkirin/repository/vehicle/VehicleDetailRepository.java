package com.parkirin.repository.vehicle;

import com.parkirin.model.parking.ParkingDetail;
import com.parkirin.model.parking.ParkingPrice;
import com.parkirin.model.vehicle.VehicleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleDetailRepository extends JpaRepository<VehicleDetail, Integer> {
    @Query(value = "select * from dtl_vehicle where dtl_vehicle_id = ?1", nativeQuery = true)
    VehicleDetail findId(Integer id);
}
