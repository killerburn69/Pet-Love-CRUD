package com.example.petlove.service.dichvu;

import com.example.petlove.dtos.dichvu.DichVuDto;
import com.example.petlove.entities.DichVu;
import com.example.petlove.exception.InvalidException;
import com.example.petlove.exception.NotFoundException;
import com.example.petlove.repository.DichVuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;

@Slf4j
@Service
public class DichVuServiceImpl implements DichVuService{
    private final DichVuRepository dichVuRepository;

    public DichVuServiceImpl(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }
    @Override
    public DichVu getDichVu(String id){
        return dichVuRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Mã dịch vụ %s này không tồn tại",id)));
    }
    @Override
    public DichVu create(DichVuDto dto, Principal principal) {
        if(ObjectUtils.isEmpty(dto.getMaDichVu())){
            throw new InvalidException("Mã dịch vụ không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(dto.getGiaDichVus())){
            throw new InvalidException("Giá dịch vụ không được để trống");
        }
        if(ObjectUtils.isEmpty(dto.getTenDichVu())){
            throw new InvalidException("Tên dịch vụ không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(dto.getNoiDung())){
            throw new InvalidException("Nội dung dịch vụ không được bỏ trống");
        }
        if(dichVuRepository.kiemTraMaDichVu(dto.getMaDichVu())){
            throw new InvalidException(String.format("Mã dịch vụ %s đã tồn tại", dto.getMaDichVu()));
        }
        DichVu dichVu = new DichVu();
        dichVu.setMaDichVu(dto.getMaDichVu().trim());
        dichVu.setTenDichVu(dto.getTenDichVu().trim());
        dichVu.setNoiDung(dto.getNoiDung().trim());
        dichVu.setGiaDichVus(dto.getGiaDichVus());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu update(String id, DichVuDto dto, Principal principal) {
        DichVu dichVu = getDichVu(id);
        if(ObjectUtils.isEmpty(dto.getMaDichVu())){
            throw new InvalidException("Mã dịch vụ không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(dto.getGiaDichVus())){
            throw new InvalidException("Giá dịch vụ không được để trống");
        }
        if(ObjectUtils.isEmpty(dto.getTenDichVu())){
            throw new InvalidException("Tên dịch vụ không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(dto.getNoiDung())){
            throw new InvalidException("Nội dung dịch vụ không được bỏ trống");
        }
        if(dichVu.getMaDichVu().equalsIgnoreCase(dto.getMaDichVu())&&dichVuRepository.kiemTraMaDichVu(dto.getMaDichVu())){
            throw new InvalidException(String.format("Mã dịch vụ %s đã tồn tại", dto.getMaDichVu()));
        }
        dichVu.setMaDichVu(dto.getMaDichVu());
        dichVu.setTenDichVu(dto.getTenDichVu());
        dichVu.setNoiDung(dto.getNoiDung());
        dichVu.setGiaDichVus(dto.getGiaDichVus());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu delete(String id) {
        DichVu dichVu = getDichVu(id);
        dichVuRepository.delete(dichVu);
        return dichVu;
    }
}
