package com.parkirin.model.parking;

import com.parkirin.model.vehicle.Vehicle;
import com.parkirin.model.vehicle.VehicleDetail;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "dtl_parking")
public class ParkingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private Integer parkingId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private VehicleDetail vehicleDetail;
    @Temporal(TemporalType.DATE)
    @Column(name = "parking_date_start", nullable = false)
    private Date parkingStart;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_price_id")
    private ParkingPrice parkingPrice;
    @Column(nullable = false)
    private Integer duration;

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public VehicleDetail getVehicleDetail() {
        return vehicleDetail;
    }

    public void setVehicleDetail(VehicleDetail vehicleDetail) {
        this.vehicleDetail = vehicleDetail;
    }

    public Date getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(Date parkingStart) {
        this.parkingStart = parkingStart;
    }

    public ParkingPrice getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(ParkingPrice parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
