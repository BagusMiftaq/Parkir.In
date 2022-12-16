package com.parkirin.service.owner;

import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.model.owner.Owner;
import com.parkirin.model.request.owner.OwnerRequest;
import com.parkirin.repository.owner.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner register(OwnerRequest owner) {
        try{
            Owner newOwner = new Owner();
            newOwner.setOwnerName(owner.getOwnerName());
            newOwner.setPhone(owner.getPhone());
            return ownerRepository.save(newOwner);
        } catch (EntityExcistException e){
            throw new EntityExcistException();
        }
    }

    @Override
    public List<Owner> viewAll() {
        try {
            List<Owner> owners = ownerRepository.findAll();
            return owners;
        } catch (Exception e){
            throw new NotFoundException("data is empty");
        }
    }

    @Override
    public List<Owner> viewByName(String name) {
        try {
            List<Owner> owners = ownerRepository.findByName(name);
            return owners;
        } catch (Exception e){
            throw new NotFoundException("owners not found");
        }
    }

    @Override
    public Owner spesifictName(String name) {
        try {
            Owner owner = ownerRepository.spesifictName(name);
            return owner;
        } catch (Exception e){
            throw new NotFoundException("owners not found");
        }
    }
}
