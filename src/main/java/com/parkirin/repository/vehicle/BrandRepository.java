package com.parkirin.repository.vehicle;

import com.parkirin.model.vehicle.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query(value = "select * from brand where vehicle_brand = ?1", nativeQuery = true)
    Brand spesifictName(String name);
}
