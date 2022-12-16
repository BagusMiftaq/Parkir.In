package com.parkirin.controller.support.vehicle;

import com.parkirin.model.response.SuccessResponse;
import com.parkirin.model.vehicle.Brand;
import com.parkirin.service.vehicle.BrandService;
import com.parkirin.utils.UrlMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.BRN_URL)
public class BrandController {
    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity registerType(@RequestBody Brand input) throws Exception{
        Brand result  = brandService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register an owner", result));
    }

    @GetMapping
    public ResponseEntity listOwner() throws Exception{
        List<Brand> result  = brandService.viewAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Owner List", result));
    }
}
