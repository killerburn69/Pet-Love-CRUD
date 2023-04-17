package com.example.petlove.service.taikhoan;

import com.example.petlove.dtos.taikhoan.TaiKhoanDto;
import com.example.petlove.entities.TaiKhoan;
import com.example.petlove.exception.InvalidException;
import com.example.petlove.exception.NotFoundException;
import com.example.petlove.repository.TaiKhoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanServiceImpl(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan(String search) {
        return null;
    }

    @Override
    public TaiKhoan getTaiKhoan(String id) {
        return taiKhoanRepository.findById(id)
                .orElseThrow(()->new NotFoundException(String.format("Tài khoản có id %s không tồn tại", id)));
    }

    @Override
    public TaiKhoan create(TaiKhoanDto dto, Principal principal) {
        if(ObjectUtils.isEmpty(dto.getEmail())){
            throw new InvalidException("Tên email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Tên không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getPassword())){
            throw new InvalidException("Password không được bỏ trống");
        }
        if(taiKhoanRepository.kiemTraEmail(dto.getEmail())){
            throw new InvalidException(String.format("Email %s này đã tồn tại",dto.getEmail()));
        }
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setEmail(dto.getEmail().trim());
        taiKhoan.setPassword(dto.getPassword().trim());
        taiKhoan.setName(dto.getName().trim());
        taiKhoan.setDienThoai(dto.getSoDienThoai().trim());
        taiKhoan.setRoles(dto.getRoles());
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan update(String id, TaiKhoanDto dto, Principal principal) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        if(ObjectUtils.isEmpty(dto.getEmail())){
            throw new InvalidException("Email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getPassword())){
            throw new InvalidException("Password không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Name không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(dto.getSoDienThoai())){
            throw new InvalidException("Số điện thoại không đưuọc bỏ trống");
        }
        if(taiKhoan.getEmail().equalsIgnoreCase(dto.getEmail())
            && taiKhoanRepository.kiemTraEmail(dto.getEmail())
        ){
            throw new InvalidException(String.format("Email %s này đã tồn tại",dto.getEmail()));
        }
        taiKhoan.setEmail(dto.getEmail().trim());
        taiKhoan.setPassword(dto.getPassword().trim());
        taiKhoan.setName(dto.getName().trim());
        taiKhoan.setDienThoai(dto.getSoDienThoai().trim());
        taiKhoan.setRoles(dto.getRoles());
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan delete(String id) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        taiKhoanRepository.delete(taiKhoan);
        return taiKhoan;
    }
}
