package com.parkirin.service.parking;

import com.parkirin.model.parking.ParkingDetail;
import com.parkirin.model.parking.ParkingOut;
import com.parkirin.model.report.ParkingReport;
import com.parkirin.model.request.parking.ParkingOutRequest;
import com.parkirin.repository.parking.ParkingDetailRepository;
import com.parkirin.repository.parking.ParkingOutRepository;
import com.parkirin.utils.DayBeetweenDates;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingOutServiceImpl implements ParkingOutService{
    ParkingDetailRepository parkingDetailRepository;
    ParkingOutRepository parkingOutRepository;

    public ParkingOutServiceImpl(ParkingDetailRepository parkingDetailRepository, ParkingOutRepository parkingOutRepository) {
        this.parkingDetailRepository = parkingDetailRepository;
        this.parkingOutRepository = parkingOutRepository;
    }

    @Override
    public ParkingOut register(ParkingOutRequest parkingOut) {
        ParkingOut newOut = new ParkingOut();
        ParkingDetail detail = parkingDetailRepository.findId(parkingOut.getParkingId());
        newOut.setParkingDetail(detail);
        newOut.setParkingTake(parkingOut.getParkingTake());
        if(DayBeetweenDates.differentDay(detail.getParkingStart(),newOut.getParkingTake())>detail.getDuration()
                && (detail.getParkingPrice().getParkingPriceId()==1 || detail.getParkingPrice().getParkingPriceId()==2)){
            newOut.setDiscount(0);
            newOut.setFine(5);
        } else if (DayBeetweenDates.differentDay(detail.getParkingStart(),newOut.getParkingTake())<=detail.getDuration()
                && (detail.getParkingPrice().getParkingPriceId()==1 || detail.getParkingPrice().getParkingPriceId()==2)) {
            newOut.setDiscount(10);
            newOut.setFine(0);
        } else if (DayBeetweenDates.differentDay(detail.getParkingStart(),newOut.getParkingTake())<=detail.getDuration()
                && (detail.getParkingPrice().getParkingPriceId()==3 || detail.getParkingPrice().getParkingPriceId()==4)){
            newOut.setDiscount(5);
            newOut.setFine(0);
        } else {
            newOut.setDiscount(0);
            newOut.setFine(10);
        }

        ParkingOut result = parkingOutRepository.save(newOut);
        return result;
    }

    @Override
    public List<ParkingOut> list() {
        List<ParkingOut> result = parkingOutRepository.findAll();
        return result;
    }

    @Override
    public List<ParkingReport> showReport() {
        List<ParkingReport> result = parkingOutRepository.findAll().stream().map(report ->{
            return new ParkingReport(
                    report.getParkingOutId(),
                    report.getParkingDetail().getParkingStart(),
                    report.getParkingTake(),
                    report.getParkingDetail().getVehicleDetail().getVehicle().getNumberPlate(),
                    report.getParkingDetail().getVehicleDetail().getOwner().getOwnerName(),
                    report.getParkingDetail().getParkingPrice().getPrice(),
                    report.getParkingDetail().getDuration(),
                    report.getDiscount(),
                    report.getFine(),
                    (report.getParkingDetail().getParkingPrice().getPrice() * report.getParkingDetail().getDuration()
                            -(report.getParkingDetail().getParkingPrice().getPrice() * report.getDiscount()/100)
                    +((((DayBeetweenDates.differentDay(report.getParkingDetail().getParkingStart(), report.getParkingTake()))-report.getParkingDetail().getDuration())*(report.getParkingDetail().getParkingPrice().getPrice()*report.getFine()/100))
                    + (((DayBeetweenDates.differentDay(report.getParkingDetail().getParkingStart(), report.getParkingTake()))-report.getParkingDetail().getDuration())*(report.getParkingDetail().getParkingPrice().getPrice()*report.getFine()/10))))
            );
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<ParkingReport> showReportByDay(String day) {
        List<ParkingReport> result = showReport().stream().filter(f -> {
                return f.getParkingTake().toString().contains(day);
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<ParkingReport> showReportByMonth(Integer month, Integer year) {
        List<ParkingReport> result = showReport().stream().filter(f -> {
            return f.getParkingTake().toString().contains(String.valueOf(year)+"-"+(String.valueOf(month).length()==2 ? String.valueOf(month):"0"+String.valueOf(month)));
        }).collect(Collectors.toList());
        return result;
    }
}