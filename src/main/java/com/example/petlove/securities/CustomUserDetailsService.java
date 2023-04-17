package com.example.petlove.securities;

import com.example.petlove.entities.TaiKhoan;
import com.example.petlove.repository.TaiKhoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 8/29/22
 * Time      : 15:54
 * Filename  : TaiKhoanDetailsService
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final TaiKhoanRepository taiKhoanRepository;

    public CustomUserDetailsService(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public JwtUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.getUser(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Tài khoản có email %s không tồn tại", email)));
        return getUserDetails(taiKhoan);
    }

    private JwtUserDetails getUserDetails(TaiKhoan taiKhoan) {
        return new JwtUserDetails(
                taiKhoan.getName(),
                taiKhoan.getEmail(),
                taiKhoan.getPassword(),
                taiKhoan.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()),
                taiKhoan.isTrangThai()
        );
    }
}
