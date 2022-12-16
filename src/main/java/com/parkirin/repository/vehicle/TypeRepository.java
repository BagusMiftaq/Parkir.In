package com.parkirin.repository.vehicle;

import com.parkirin.model.vehicle.Brand;
import com.parkirin.model.vehicle.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query(value = "select * from type where vehicle_type = ?1", nativeQuery = true)
    Type spesifictName(String name);
}
