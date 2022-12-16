package com.parkirin.model.request.parking;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ParkingDetailRequest {
    @Temporal(TemporalType.DATE)
    private Date parkingStart;
    private Integer dtlVehicleId;
    private Integer parkingPriceId;
    private Integer duration;

    public Date getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(Date parkingStart) {
        this.parkingStart = parkingStart;
    }

    public Integer getDtlVehicleId() {
        return dtlVehicleId;
    }

    public void setDtlVehicleId(Integer dtlVehicleId) {
        this.dtlVehicleId = dtlVehicleId;
    }

    public Integer getParkingPriceId() {
        return parkingPriceId;
    }

    public void setParkingPriceId(Integer parkingPriceId) {
        this.parkingPriceId = parkingPriceId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
