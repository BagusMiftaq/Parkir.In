package com.parkirin.model.report;

import java.util.Date;

public class ParkingReport {
    private Integer parkingOutId;
    private Date parkingStart;
    private Date parkingTake;
    private String numberPlate;
    private String ownerName;
    private Integer price;
    private Integer duration;
    private Integer discount;
    private Integer fine;
    private Integer total;

    public ParkingReport(Integer parkingOutId, Date parkingStart, Date parkingTake, String numberPlate, String ownerName, Integer price, Integer duration, Integer discount, Integer fine, Integer total) {
        this.parkingOutId = parkingOutId;
        this.parkingStart = parkingStart;
        this.parkingTake = parkingTake;
        this.numberPlate = numberPlate;
        this.ownerName = ownerName;
        this.price = price;
        this.duration = duration;
        this.discount = discount;
        this.fine = fine;
        this.total = total;
    }

    public Integer getParkingOutId() {
        return parkingOutId;
    }

    public void setParkingOutId(Integer parkingOutId) {
        this.parkingOutId = parkingOutId;
    }

    public Date getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(Date parkingStart) {
        this.parkingStart = parkingStart;
    }

    public Date getParkingTake() {
        return parkingTake;
    }

    public void setParkingTake(Date parkingTake) {
        this.parkingTake = parkingTake;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
