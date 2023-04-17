package com.example.petlove.service.loaithucung;

import com.example.petlove.dtos.loaithucung.LoaiThuCungDto;
import com.example.petlove.entities.LoaiThuCung;
import com.example.petlove.exception.InvalidException;
import com.example.petlove.exception.NotFoundException;
import com.example.petlove.repository.LoaiThuCungRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
@Slf4j
@Service
public class LoaiThuCungServiceImpl implements LoaiThuCungService{
    private final LoaiThuCungRepository loaiThuCungRepository;

    public LoaiThuCungServiceImpl(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }
    public LoaiThuCung getLoaiThuCung(String id){
        return loaiThuCungRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Mã thú cưng %s này không tồn tại",id)));
    }
    @Override
    public LoaiThuCung create(LoaiThuCungDto dto, Principal principal) {
        if(ObjectUtils.isEmpty(dto.getMaLoaiThuCung())){
            throw new InvalidException("Mã thú cưng không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getTenLoaiThuCung())){
            throw new InvalidException("Tên thú cưng không được bỏ trống");
        }
        if(loaiThuCungRepository.kiemTraMaLoaiThuCung(dto.getMaLoaiThuCung())){
            throw new InvalidException(String.format("Mã %s thú cưng này đã có", dto.getMaLoaiThuCung()));
        }
        LoaiThuCung loaiThuCung = new LoaiThuCung();
        loaiThuCung.setMaLoaiThuCung(dto.getMaLoaiThuCung().trim());
        loaiThuCung.setTenLoaiThuCung(dto.getTenLoaiThuCung());
        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung update(String id, LoaiThuCungDto dto, Principal principal) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        if(ObjectUtils.isEmpty(dto.getMaLoaiThuCung())){
            throw new InvalidException("Mã loại thú cưng không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(dto.getTenLoaiThuCung())){
            throw new InvalidException("Tên loại thú cưng không được bỏ trống");

        }
        if(loaiThuCung.getMaLoaiThuCung().equalsIgnoreCase(dto.getMaLoaiThuCung()) && loaiThuCungRepository.kiemTraMaLoaiThuCung(dto.getMaLoaiThuCung())){
            throw new InvalidException(String.format("Mã %s thú cưng này đã có", dto.getMaLoaiThuCung()));
        }
        loaiThuCung.setMaLoaiThuCung(dto.getMaLoaiThuCung().trim());
        loaiThuCung.setTenLoaiThuCung(dto.getTenLoaiThuCung());
        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung delete(String id) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        loaiThuCungRepository.delete(loaiThuCung);
        return loaiThuCung;
    }
}
