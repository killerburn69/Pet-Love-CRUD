package com.example.petlove.controller;

import com.example.petlove.dtos.datcho.DatChoDto;
import com.example.petlove.entities.DatCho;
import com.example.petlove.service.datcho.DatChoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/dat-cho")
public class DatChoController {
    @Autowired
    private final DatChoService datChoService;

    public DatChoController(DatChoService datChoService) {
        this.datChoService = datChoService;
    }
    @ApiOperation(value = "create dat cho")
    @PostMapping
    public ResponseEntity<DatCho> create(@Valid @RequestBody DatChoDto dto, Principal principal){
        return new ResponseEntity<>(datChoService.create(dto,principal), HttpStatus.OK);
    }
    @ApiOperation(value = "update dat cho")
    @PutMapping("/{id}")
    public ResponseEntity<DatCho> update(@PathVariable String id, @Valid @RequestBody DatChoDto dto, Principal principal){
        return new ResponseEntity<>(datChoService.update(id,dto,principal), HttpStatus.OK);


    }
    @ApiOperation(value = "delete dat cho")
    @DeleteMapping("/{id}")
    public ResponseEntity<DatCho> delete(@PathVariable String id){
        return new ResponseEntity<>(datChoService.delete(id),HttpStatus.OK);
    }
}
