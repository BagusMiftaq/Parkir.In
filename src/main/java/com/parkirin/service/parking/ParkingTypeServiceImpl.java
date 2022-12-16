package com.parkirin.service.parking;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.parking.Area;
import com.parkirin.model.parking.ParkingType;
import com.parkirin.model.request.parking.ParkingTypeRequest;
import com.parkirin.repository.parking.AreaRepository;
import com.parkirin.repository.parking.ParkingTypeRepository;
import com.parkirin.utils.LowerAndSplit;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingTypeServiceImpl implements ParkingTypeService{

    ParkingTypeRepository parkingTypeRepository;

    AreaRepository areaRepository;

    public ParkingTypeServiceImpl(ParkingTypeRepository parkingTypeRepository, AreaRepository areaRepository) {
        this.parkingTypeRepository = parkingTypeRepository;
        this.areaRepository = areaRepository;
    }

    @Override
    public ParkingType register(ParkingTypeRequest parkingType) {
        try{
            ParkingType newParkingType = new ParkingType();
            newParkingType.setParkingTypeVariant(parkingType.getParkingTypeVariant());

            Area existingArea = areaRepository.spesificName(parkingType.getParkingArea());
            newParkingType.setArea(existingArea);

            ParkingType result = parkingTypeRepository.save(newParkingType);
            return result;

        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }
    }

    @Override
    public List<ParkingType> viewAll() {
        try {
            List<ParkingType> result = parkingTypeRepository.findAll();
            return result;
        }
        catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }

    @Override
    public ParkingType spesificName(String name) {
        ParkingType result = parkingTypeRepository.spesificName(name);
        return result;
    }
}
