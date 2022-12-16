package com.parkirin.service.parking;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.parking.Area;
import com.parkirin.repository.parking.AreaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{

    AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area register(Area area) {
       try{
           Area result = areaRepository.save(area);
           return result;
       } catch (DataIntegrityViolationException e){
           throw new EntityExcistException();
       }
    }

    @Override
    public List<Area> viewAll() {
        try {
            List<Area> result = areaRepository.findAll();
            return result;
        } catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }

    @Override
    public Area spesificName(String name) {
        Area result = areaRepository.spesificName(name);
        return result;
    }
}
