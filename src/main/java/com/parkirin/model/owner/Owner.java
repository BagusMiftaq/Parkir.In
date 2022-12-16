package com.parkirin.model.owner;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parkirin.model.vehicle.VehicleDetail;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "owner_name", nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "owner")
//    @JsonBackReference
    List<VehicleDetail> vehicleDetailList;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<VehicleDetail> getVehicleDetailList() {
        return vehicleDetailList;
    }

    public void setVehicleDetailList(List<VehicleDetail> vehicleDetailList) {
        this.vehicleDetailList = vehicleDetailList;
    }
}
