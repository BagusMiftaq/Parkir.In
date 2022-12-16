package com.parkirin.model.parking;

import javax.persistence.*;

@Entity
@Table(name = "parking_type")
public class ParkingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_type_id")
    private Integer parkingTypeId;
    @Column(name = "parking_type_variant", nullable = false)
    private String parkingTypeVariant;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    private Area area;
    @Column(name = "status")
    private Boolean isActive = true;

    public Integer getParkingTypeId() {
        return parkingTypeId;
    }

    public void setParkingTypeId(Integer parkingTypeId) {
        this.parkingTypeId = parkingTypeId;
    }

    public String getParkingTypeVariant() {
        return parkingTypeVariant;
    }

    public void setParkingTypeVariant(String parkingTypeVariant) {
        this.parkingTypeVariant = parkingTypeVariant;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
