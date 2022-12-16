package com.parkirin.controller.main;

import com.parkirin.model.owner.Owner;
import com.parkirin.model.request.owner.OwnerRequest;
import com.parkirin.model.response.SuccessResponse;
import com.parkirin.service.owner.OwnerService;
import com.parkirin.utils.UrlMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "OWNER")
@RestController
@RequestMapping(UrlMapping.OWNER_URL)
public class OwnerController {
    OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @PostMapping
    public ResponseEntity registerOwner(@RequestBody OwnerRequest input) throws Exception{
        Owner result  = ownerService.register(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success register an owner", result));
    }

    @GetMapping
    public ResponseEntity listOwner() throws  Exception{
        List<Owner> result  = ownerService.viewAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Owner List", result));
    }

    @GetMapping("/name")
    public ResponseEntity findByName(@RequestParam String name) throws Exception{
        List<Owner> result  = ownerService.viewByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Owner List", result));
    }

}
