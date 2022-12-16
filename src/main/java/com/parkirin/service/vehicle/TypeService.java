package com.parkirin.service.vehicle;

import com.parkirin.model.vehicle.Brand;
import com.parkirin.model.vehicle.Type;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeService {
    Type register(Type type);
    List<Type> viewAll();
    Type spesifictName(String name);
}
