package com.parkirin.model.request.parking;

public class ParkingTypeRequest {
    private String parkingTypeVariant;

    private String parkingArea;

    public String getParkingTypeVariant() {
        return parkingTypeVariant;
    }

    public void setParkingTypeVariant(String parkingTypeVariant) {
        this.parkingTypeVariant = parkingTypeVariant;
    }

    public String getParkingArea() {
        return parkingArea;
    }

    public void setParkingArea(String parkingArea) {
        this.parkingArea = parkingArea;
    }
}
