package com.parkirin.service.vehicle;

import com.parkirin.model.vehicle.Brand;

import java.util.List;

public interface BrandService {
    Brand register(Brand brand);
    List<Brand> viewAll();
    Brand spesifictName(String name);
}
