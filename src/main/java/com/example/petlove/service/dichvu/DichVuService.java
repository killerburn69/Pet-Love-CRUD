package com.example.petlove.service.dichvu;

import com.example.petlove.dtos.dichvu.DichVuDto;
import com.example.petlove.entities.DichVu;

import java.security.Principal;

public interface DichVuService {
    DichVu getDichVu(String id);

    DichVu create(DichVuDto dto, Principal principal);
    DichVu update(String id, DichVuDto dto, Principal principal);
    DichVu delete(String id);
}
