package com.parkirin.service.vehicle;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.vehicle.Vehicle;
import com.parkirin.repository.vehicle.VehicleRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle register(Vehicle vehicle) {
        try{
            Vehicle result = vehicleRepository.save(vehicle);
            return result;
        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }

    }

    @Override
    public List<Vehicle> viewAll() {
        try {
            List<Vehicle> result = vehicleRepository.findAll();
            return result;
        } catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }

    @Override
    public Vehicle spesifictName(String name) {
        try {
            Vehicle result = vehicleRepository.spesifictName(name);
            return  result;
        } catch (Exception e){
            throw new NotFoundException("Vehicle not found");
        }
    }
}
