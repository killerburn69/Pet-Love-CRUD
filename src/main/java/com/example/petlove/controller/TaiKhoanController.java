package com.example.petlove.controller;

import com.example.petlove.dtos.taikhoan.TaiKhoanDto;
import com.example.petlove.entities.TaiKhoan;
import com.example.petlove.repository.TaiKhoanRepository;
import com.example.petlove.service.taikhoan.TaiKhoanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/user")
public class TaiKhoanController {
    @Autowired
    private final TaiKhoanService taiKhoanService;
    public TaiKhoanController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }
    @ApiOperation(value = "Create user")
    @PostMapping
    public ResponseEntity<TaiKhoan> create(@Valid @RequestBody TaiKhoanDto dto, Principal principal){
        return new ResponseEntity<>(taiKhoanService.create(dto,principal), HttpStatus.OK);
    }
    @ApiOperation(value = "Update tai khoản")
    @PutMapping("/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable String id, @Valid @RequestBody TaiKhoanDto dto, Principal principal){
        return new ResponseEntity<>(taiKhoanService.update(id, dto, principal),HttpStatus.OK);
    }
    @ApiOperation(value = "Xóa User")
    @DeleteMapping("/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable String id){
        return new ResponseEntity<>(taiKhoanService.delete(id),HttpStatus.OK);
    }
}
