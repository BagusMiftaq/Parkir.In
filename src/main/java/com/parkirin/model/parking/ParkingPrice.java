package com.parkirin.model.parking;

import javax.persistence.*;

@Entity
@Table(name = "parking_price")
public class ParkingPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_price_id")
    private Integer parkingPriceId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_type_id")
    private ParkingType parkingType;
    @Column(nullable = false)
    private Integer price;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Integer getParkingPriceId() {
        return parkingPriceId;
    }

    public void setParkingPriceId(Integer parkingPriceId) {
        this.parkingPriceId = parkingPriceId;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
