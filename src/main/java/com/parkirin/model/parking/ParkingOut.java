package com.parkirin.model.parking;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "parking_out")
public class ParkingOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paking_out_id")
    private Integer parkingOutId;
    @OneToOne
    @JoinColumn(name = "parking_id")
    private ParkingDetail parkingDetail;
    @Temporal(TemporalType.DATE)
    @Column(name = "parking_date_take", nullable = false)
    private Date parkingTake;
    @Column(nullable = false)
    private Integer discount;
    @Column(nullable = false)
    private Integer fine;

    public Integer getParkingOutId() {
        return parkingOutId;
    }

    public void setParkingOutId(Integer parkingOutId) {
        this.parkingOutId = parkingOutId;
    }

    public ParkingDetail getParkingDetail() {
        return parkingDetail;
    }

    public void setParkingDetail(ParkingDetail parkingDetail) {
        this.parkingDetail = parkingDetail;
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
