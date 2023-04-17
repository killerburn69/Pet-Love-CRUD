package com.example.petlove.service.taikhoan;

import com.example.petlove.dtos.taikhoan.TaiKhoanDto;
import com.example.petlove.entities.TaiKhoan;

import java.security.Principal;
import java.util.List;

public interface TaiKhoanService{
    List<TaiKhoan> getAllTaiKhoan(String search);
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan create(TaiKhoanDto dto, Principal principal);
    TaiKhoan update(String id, TaiKhoanDto dto, Principal principal);
    TaiKhoan delete(String id);
}
