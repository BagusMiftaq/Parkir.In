package com.parkirin.service.vehicle;

import com.parkirin.model.request.vehicle.VehicleDetailRequest;
import com.parkirin.model.vehicle.VehicleDetail;

import java.util.List;

public interface VehicleDetailService {

    VehicleDetail register(VehicleDetailRequest vehicleDetailRequest);
    List<VehicleDetail> viewAll();
}
