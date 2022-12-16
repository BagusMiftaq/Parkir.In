package com.parkirin.model.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parkirin.model.owner.Owner;

import javax.persistence.*;

@Entity
@Table(name = "dtl_vehicle")
public class VehicleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dtl_vehicle_id")
    private Integer dtlVehicleId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Owner owner;
    @Column(nullable = false)
    private String color;
    public Integer getDtlVehicleId() {
        return dtlVehicleId;
    }

    public void setDtlVehicleId(Integer dtlVehicleId) {
        this.dtlVehicleId = dtlVehicleId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
