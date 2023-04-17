package com.example.petlove.repository;

import com.example.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung,String> {
    @Override
    Optional<LoaiThuCung> findById(String id);

    @Query(value = "{'maLoaiThuCung': ?0}")
    Optional<LoaiThuCung> getLoaiThuCung(String maLoaiThuCung);

    @Query(value = "{'maLoaiThuCung': ?0}", exists = true)
    boolean kiemTraMaLoaiThuCung(String maLoaiThuCung);
}
