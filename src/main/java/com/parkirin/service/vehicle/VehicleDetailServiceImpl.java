package com.parkirin.service.vehicle;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.owner.Owner;
import com.parkirin.model.request.vehicle.VehicleDetailRequest;
import com.parkirin.model.vehicle.Brand;
import com.parkirin.model.vehicle.Type;
import com.parkirin.model.vehicle.Vehicle;
import com.parkirin.model.vehicle.VehicleDetail;
import com.parkirin.repository.owner.OwnerRepository;
import com.parkirin.repository.vehicle.BrandRepository;
import com.parkirin.repository.vehicle.TypeRepository;
import com.parkirin.repository.vehicle.VehicleDetailRepository;
import com.parkirin.repository.vehicle.VehicleRepository;
import com.parkirin.utils.LowerAndSplit;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDetailServiceImpl implements VehicleDetailService{

    OwnerRepository ownerRepository;
    VehicleRepository vehicleRepository;
    VehicleDetailRepository vehicleDetailRepository;
    TypeRepository typeRepository;
    BrandRepository brandRepository;

    public VehicleDetailServiceImpl(OwnerRepository ownerRepository, VehicleRepository vehicleRepository, VehicleDetailRepository vehicleDetailRepository, TypeRepository typeRepository, BrandRepository brandRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleDetailRepository = vehicleDetailRepository;
        this.typeRepository = typeRepository;
        this.brandRepository = brandRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public VehicleDetail register(VehicleDetailRequest vehicleDetailRequest) {
        try{
            Owner owner = new Owner();
            Brand brand = new Brand();
            Type type = new Type();
            Vehicle vehicle = new Vehicle();
            VehicleDetail vehicleDetail = new VehicleDetail();

            Owner existingOwner = ownerRepository.spesifictName(vehicleDetailRequest.getOwnerName());
            if(!(existingOwner==null)){
                if(LowerAndSplit.lowNonSpace(existingOwner.getOwnerName()).equals(LowerAndSplit.lowNonSpace(vehicleDetailRequest.getOwnerName()))){
                    owner = existingOwner;
                } else {
                    Owner newOwner = new Owner();
                    newOwner.setOwnerName(vehicleDetailRequest.getOwnerName());
                    newOwner.setPhone(vehicleDetailRequest.getPhone());
                    owner = ownerRepository.save(newOwner);
                }
            }else {
                Owner newOwner = new Owner();
                newOwner.setOwnerName(vehicleDetailRequest.getOwnerName());
                newOwner.setPhone(vehicleDetailRequest.getPhone());
                owner = ownerRepository.save(newOwner);
            }

            Brand existingBrand = brandRepository.spesifictName(vehicleDetailRequest.getVehicleBrand());
            if(!(existingBrand==null)){
                if(LowerAndSplit.lowNonSpace(existingBrand.getVehicleBrand()).equals(LowerAndSplit.lowNonSpace(vehicleDetailRequest.getVehicleBrand()))){
                    brand = existingBrand;
                } else {
                    Brand newBrand = new Brand();
                    newBrand.setVehicleBrand(vehicleDetailRequest.getVehicleBrand());
                    brand = brandRepository.save(newBrand);
                }
            } else {
                Brand newBrand = new Brand();
                newBrand.setVehicleBrand(vehicleDetailRequest.getVehicleBrand());
                brand = brandRepository.save(newBrand);
            }

            Type existingType = typeRepository.spesifictName(vehicleDetailRequest.getVehicleType());
            if (!(existingType==null)){
                if(!LowerAndSplit.lowNonSpace(existingType.getVehicleType()).equals(LowerAndSplit.lowNonSpace(vehicleDetailRequest.getVehicleType()))){
                    Type newType = new Type();
                    newType.setVehicleType(vehicleDetailRequest.getVehicleType());
                    type = typeRepository.save(newType);
                } else {
                    type = existingType;
                }
            } else {
                Type newType = new Type();
                newType.setVehicleType(vehicleDetailRequest.getVehicleType());
                type = typeRepository.save(newType);
            }

            Vehicle existingVehicle = vehicleRepository.spesifictName(vehicleDetailRequest.getNumberPlate());
            if (!(existingVehicle==null)){
                if(LowerAndSplit.lowNonSpace(existingVehicle.getNumberPlate()).equals(LowerAndSplit.lowNonSpace(vehicleDetailRequest.getNumberPlate()))){
                    vehicle = existingVehicle;
                } else {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setNumberPlate(vehicleDetailRequest.getNumberPlate());
                    newVehicle.setType(type);
                    newVehicle.setBrand(brand);
                    vehicle = vehicleRepository.save(newVehicle);
                }
            } else {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setNumberPlate(vehicleDetailRequest.getNumberPlate());
                newVehicle.setType(type);
                newVehicle.setBrand(brand);
                vehicle = vehicleRepository.save(newVehicle);
            }


            VehicleDetail newVehicleDetail = new VehicleDetail();
            newVehicleDetail.setOwner(owner);
            newVehicleDetail.setVehicle(vehicle);
            newVehicleDetail.setColor(vehicleDetailRequest.getColor());

            vehicleDetail = vehicleDetailRepository.save(newVehicleDetail);

            return vehicleDetail;
        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }
    }

    @Override
    public List<VehicleDetail> viewAll() {
        try {
            List<VehicleDetail> result = vehicleDetailRepository.findAll();
            return result;
        } catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }
}
