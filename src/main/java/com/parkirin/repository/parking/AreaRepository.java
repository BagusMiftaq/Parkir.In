package com.parkirin.repository.parking;

import com.parkirin.model.parking.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AreaRepository extends JpaRepository<Area, Integer> {

    @Query(value = "select * from area where parking_area = ?1", nativeQuery = true)
    Area spesificName(String name);
}
