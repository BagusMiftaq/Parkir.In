package com.parkirin.model.request.parking;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ParkingOutRequest {
    private Integer parkingId;
    @Temporal(TemporalType.DATE)
    private Date parkingTake;
    private Integer discount;
    private Integer fine;

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Date getParkingTake() {
        return parkingTake;
    }

    public void setParkingTake(Date parkingTake) {
        this.parkingTake = parkingTake;
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
}
