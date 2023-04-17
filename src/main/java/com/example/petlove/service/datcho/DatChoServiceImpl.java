package com.example.petlove.service.datcho;

import com.example.petlove.dtos.datcho.DatChoDto;
import com.example.petlove.entities.DatCho;
import com.example.petlove.exception.InvalidException;
import com.example.petlove.exception.NotFoundException;
import com.example.petlove.repository.DatChoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
@Slf4j
@Service
public class DatChoServiceImpl implements DatChoService{
    private final DatChoRepository datChoRepository;

    public DatChoServiceImpl(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }
    @Override
    public DatCho getDatCho(String id){
        return datChoRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Không có mã đặt chỗ %s", id)));
    }
    @Override
    public DatCho create(DatChoDto dto, Principal principal) {
        if(ObjectUtils.isEmpty(dto.getEmail())){
            throw new InvalidException("Email của khách không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getTrangThaiDatCho())){
            throw new InvalidException("Trạng thái đặt chỗ không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getThoiGian())){
            throw new InvalidException("Thời gian không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getCanDan())){
            throw new InvalidException("Lời căn dặn không được bỏ qua");
        }
        if(ObjectUtils.isEmpty(dto.getThongTinDatChos())){
            throw new InvalidException("Thông tin đặt chỗ không được bỏ troongs");
        }
        DatCho datCho = new DatCho();
        datCho.setEmail(dto.getEmail().trim());
        datCho.setTrangThaiDatCho(dto.getTrangThaiDatCho().trim());
        datCho.setThoiGian(dto.getThoiGian());
        datCho.setCanDan(dto.getCanDan().trim());
        datCho.setThongTinDatChos(dto.getThongTinDatChos());
        datChoRepository.save(datCho);
        return datCho;
    }

    @Override
    public DatCho update(String id, DatChoDto dto, Principal principal) {
        DatCho datCho = getDatCho(id);
        if(ObjectUtils.isEmpty(dto.getEmail())){
            throw new InvalidException("Email của khách không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getTrangThaiDatCho())){
            throw new InvalidException("Trạng thái đặt chỗ không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getThoiGian())){
            throw new InvalidException("Thời gian không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getCanDan())){
            throw new InvalidException("Lời căn dặn không được bỏ qua");
        }
        if(ObjectUtils.isEmpty(dto.getThongTinDatChos())){
            throw new InvalidException("Thông tin đặt chỗ không được bỏ troongs");
        }
        datCho.setEmail(dto.getEmail().trim());
        datCho.setTrangThaiDatCho(dto.getTrangThaiDatCho().trim());
        datCho.setThoiGian(dto.getThoiGian());
        datCho.setCanDan(dto.getCanDan().trim());
        datCho.setThongTinDatChos(dto.getThongTinDatChos());
        datChoRepository.save(datCho);
        return datCho;
    }

    @Override
    public DatCho delete(String id) {
        DatCho datCho = getDatCho(id);
        datChoRepository.delete(datCho);
        return datCho;
    }
}
