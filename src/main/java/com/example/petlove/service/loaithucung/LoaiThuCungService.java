package com.example.petlove.service.loaithucung;

import com.example.petlove.dtos.loaithucung.LoaiThuCungDto;
import com.example.petlove.entities.LoaiThuCung;

import java.security.Principal;

public interface LoaiThuCungService {
    LoaiThuCung create(LoaiThuCungDto dto, Principal principal);
    LoaiThuCung update(String id, LoaiThuCungDto dto, Principal principal);
    LoaiThuCung delete(String id);
}
