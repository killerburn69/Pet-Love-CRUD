package com.example.petlove.dtos.taikhoan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDto {
    private String email;

    private String password;

    private String name;

    private String soDienThoai;

    private List<String> roles = new ArrayList<>();
}
