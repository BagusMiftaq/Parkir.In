package com.parkirin.controller.support.vehicle;

import com.parkirin.model.response.SuccessResponse;
import com.parkirin.model.vehicle.Type;
import com.parkirin.service.vehicle.TypeService;
import com.parkirin.utils.UrlMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.TYP_URL)
public class TypeController {

    TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity registerType(@RequestBody Type input) throws Exception{
        Type result  = typeService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register an owner", result));
    }

    @GetMapping
    public ResponseEntity list() throws Exception{
        List<Type> result  = typeService.viewAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Owner List", result));
    }
}
