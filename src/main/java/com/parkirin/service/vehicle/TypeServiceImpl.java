package com.parkirin.service.vehicle;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.vehicle.Type;
import com.parkirin.repository.vehicle.TypeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type register(Type type) {
        try {
            Type result = typeRepository.save(type);
            return result;
        } catch (DataIntegrityViolationException e){
            throw new EntityExcistException();
        }
    }

    @Override
    public List<Type> viewAll() {
        try {

            List<Type> result = typeRepository.findAll();
            return result;
        }
        catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }

    @Override
    public Type spesifictName(String name) {
        try {
            Type result = typeRepository.spesifictName(name);
            return result;
        } catch (Exception e){
            throw new NotFoundException("type not found");
        }

    }
}
