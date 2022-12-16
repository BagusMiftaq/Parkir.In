package com.parkirin.service.parking;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.parking.ParkingPrice;
import com.parkirin.model.parking.ParkingType;
import com.parkirin.model.request.parking.ParkingPriceRequest;
import com.parkirin.repository.parking.ParkingPriceRepository;
import com.parkirin.repository.parking.ParkingTypeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingPriceServiceImpl implements ParkingPriceService{

    ParkingPriceRepository parkingPriceRepository;
    ParkingTypeRepository parkingTypeRepository;

    public ParkingPriceServiceImpl(ParkingPriceRepository parkingPriceRepository, ParkingTypeRepository parkingTypeRepository) {
        this.parkingPriceRepository = parkingPriceRepository;
        this.parkingTypeRepository = parkingTypeRepository;
    }

    @Override
    public ParkingPrice register(ParkingPriceRequest parkingPrice) {
        try{
            ParkingPrice newPrice = new ParkingPrice();
            ParkingType exType = parkingTypeRepository.spesificName(parkingPrice.getParkingTypeVariant());
            newPrice.setPrice(parkingPrice.getPrice());
            newPrice.setParkingType(exType);
            ParkingPrice result = parkingPriceRepository.save(newPrice);
            return result;
        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }

    }

    @Override
    public List<ParkingPrice> viewAll() {
        try {
            List<ParkingPrice> result = parkingPriceRepository.findAll();
            return result;
        }
        catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }
}
