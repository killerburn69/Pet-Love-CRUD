package com.example.petlove.controller;

import com.example.petlove.dtos.loaithucung.LoaiThuCungDto;
import com.example.petlove.entities.LoaiThuCung;
import com.example.petlove.service.loaithucung.LoaiThuCungService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/loai-thu-cung")
public class LoaiThuCungController {
    @Autowired
    private final LoaiThuCungService loaiThuCungService;

    public LoaiThuCungController(LoaiThuCungService loaiThuCungService) {
        this.loaiThuCungService = loaiThuCungService;
    }

    @ApiOperation(value = "Create loại thú cưng")
    @PostMapping
    public ResponseEntity<LoaiThuCung> create(@Valid @RequestBody LoaiThuCungDto dto, Principal principal){
        return new ResponseEntity<>(loaiThuCungService.create(dto,principal), HttpStatus.OK);
    }

    @ApiOperation(value = "Update loại thú cưng")
    @PutMapping("/{id}")
    public ResponseEntity<LoaiThuCung> update(@PathVariable String id, @Valid @RequestBody LoaiThuCungDto dto, Principal principal){
        return new ResponseEntity<>(loaiThuCungService.update(id,dto,principal),HttpStatus.OK);
    }
    @ApiOperation(value = "Xóa loai thu cung")
    @DeleteMapping("/{id}")
    public ResponseEntity<LoaiThuCung> delete(@PathVariable String id){
        return new ResponseEntity<>(loaiThuCungService.delete(id),HttpStatus.OK);
    }
}
