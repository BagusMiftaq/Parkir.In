package com.parkirin.service.parking;

import com.parkirin.model.parking.Area;

import java.util.List;

public interface AreaService {
    Area register(Area area);
    List<Area> viewAll();
    Area spesificName(String name);
}
