package com.example.petlove.service.datcho;

import com.example.petlove.dtos.datcho.DatChoDto;
import com.example.petlove.entities.DatCho;

import java.security.Principal;

public interface DatChoService {
    DatCho getDatCho(String id);

    DatCho create(DatChoDto dto, Principal principal);
    DatCho update(String id, DatChoDto dto, Principal principal);
    DatCho delete(String id);
}
