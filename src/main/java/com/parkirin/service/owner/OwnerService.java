package com.parkirin.service.owner;

import com.parkirin.model.owner.Owner;
import com.parkirin.model.request.owner.OwnerRequest;

import java.util.List;

public interface OwnerService {

    Owner register(OwnerRequest owner);
    List<Owner> viewAll();

    List<Owner> viewByName(String name);

    Owner spesifictName(String name);
}
