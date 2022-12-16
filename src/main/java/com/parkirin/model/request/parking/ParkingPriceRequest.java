package com.parkirin.model.request.parking;

public class ParkingPriceRequest {
    private String parkingTypeVariant;
    private Integer price;

    public String getParkingTypeVariant() {
        return parkingTypeVariant;
    }

    public void setParkingTypeVariant(String parkingTypeVariant) {
        this.parkingTypeVariant = parkingTypeVariant;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
