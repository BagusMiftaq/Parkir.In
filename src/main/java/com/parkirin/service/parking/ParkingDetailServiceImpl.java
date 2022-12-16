package com.parkirin.service.parking;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.parking.ParkingDetail;
import com.parkirin.model.parking.ParkingPrice;
import com.parkirin.model.request.parking.ParkingDetailRequest;
import com.parkirin.model.vehicle.VehicleDetail;
import com.parkirin.repository.parking.ParkingDetailRepository;
import com.parkirin.repository.parking.ParkingPriceRepository;
import com.parkirin.repository.vehicle.VehicleDetailRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingDetailServiceImpl implements ParkingDetailService{

    ParkingDetailRepository parkingDetailRepository;
    ParkingPriceRepository parkingPrice;

    VehicleDetailRepository vehicleDetailRepository;

    public ParkingDetailServiceImpl(ParkingDetailRepository parkingDetailRepository, ParkingPriceRepository parkingPrice, VehicleDetailRepository vehicleDetailRepository) {
        this.parkingDetailRepository = parkingDetailRepository;
        this.parkingPrice = parkingPrice;
        this.vehicleDetailRepository = vehicleDetailRepository;
    }

    @Override
    public ParkingDetail register(ParkingDetailRequest parkingDetail) {
        try{
            ParkingDetail newDetail = new ParkingDetail();
            ParkingPrice price = parkingPrice.findId(parkingDetail.getParkingPriceId());
            VehicleDetail vehicleDetail = vehicleDetailRepository.findId(parkingDetail.getDtlVehicleId());
            newDetail.setParkingPrice(price);
            newDetail.setVehicleDetail(vehicleDetail);
            newDetail.setParkingStart(parkingDetail.getParkingStart());
            newDetail.setDuration(parkingDetail.getDuration());

            ParkingDetail result = parkingDetailRepository.save(newDetail);
            return result;
        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }
    }

    @Override
    public List<ParkingDetail> list() {
        try {
            List<ParkingDetail> result = parkingDetailRepository.findAll();
            return result;
        } catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }
}
