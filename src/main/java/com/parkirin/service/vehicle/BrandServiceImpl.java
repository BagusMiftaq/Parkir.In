package com.parkirin.service.vehicle;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.vehicle.Brand;
import com.parkirin.repository.vehicle.BrandRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand register(Brand brand) {
        try {
            Brand result = brandRepository.save(brand);
            return result;

        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }
    }

    @Override
    public List<Brand> viewAll() {
        try {
            List<Brand> result = brandRepository.findAll();
            return result;
        }
        catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }

    @Override
    public Brand spesifictName(String name) {
        try{
            Brand result = brandRepository.spesifictName(name);
            return result;
        } catch (Exception e){
            throw new NotFoundException("brand not found");
        }
    }
}
