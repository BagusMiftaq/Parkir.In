package com.parkirin.repository.owner;

import com.parkirin.model.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{
    @Query(value = "select * from owner where owner_name like %?1%", nativeQuery = true)
    List<Owner> findByName(String name);

    @Query(value = "select * from owner where owner_name = ?1", nativeQuery = true)
    Owner spesifictName(String name);

}
