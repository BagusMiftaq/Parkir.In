package com.parkirin.controller.support.parking;

import com.parkirin.model.parking.Area;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.model.vehicle.VehicleDetail;
import com.parkirin.service.parking.AreaService;
import com.parkirin.utils.UrlMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.ARE_URL)
public class AreaController {

    AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping
    public ResponseEntity registerArea(@RequestBody Area input) throws Exception{
        Area result  = areaService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register an area", result));
    }

    @GetMapping
    public ResponseEntity listArea() throws Exception{
        List<Area> result  = areaService.viewAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Area List", result));
    }
}
