package com.example.petlove.controller;

import com.example.petlove.dtos.dichvu.DichVuDto;
import com.example.petlove.entities.DichVu;
import com.example.petlove.service.dichvu.DichVuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/dich-vu")
public class DichVuController {
    @Autowired
    private final DichVuService dichVuService;

    public DichVuController(DichVuService dichVuService) {
        this.dichVuService = dichVuService;
    }
    @ApiOperation(value = "Create user")
    @PostMapping
    public ResponseEntity<DichVu> create(@Valid @RequestBody DichVuDto dto, Principal principal){
        return new ResponseEntity<>(dichVuService.create(dto,principal), HttpStatus.OK);
    }
    @ApiOperation(value = "Update user")
    @PutMapping("/{id}")
    public ResponseEntity<DichVu> update(@PathVariable String id, @Valid @RequestBody DichVuDto dto, Principal principal){
        return new ResponseEntity<>(dichVuService.update(id,dto,principal), HttpStatus.OK);
    }
    @ApiOperation(value = "Delete dịch vụ")
    @DeleteMapping("/{id}")
    public ResponseEntity<DichVu> delete(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.delete(id),HttpStatus.OK);
    }

}
