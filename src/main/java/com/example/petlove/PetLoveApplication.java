package com.example.petlove;

import com.example.petlove.entities.TaiKhoan;
import com.example.petlove.repository.TaiKhoanRepository;
import com.example.petlove.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PetLoveApplication implements CommandLineRunner {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    public static void main(String[] args) {
        SpringApplication.run(PetLoveApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(taiKhoanRepository.count()==0){
            TaiKhoan taiKhoan =new TaiKhoan("kiet", "kiet123@gmail.com","123456","0934844649",Arrays.asList(EnumRole.ADMIN.name()));
            taiKhoanRepository.save(taiKhoan);
        }
    }
}
