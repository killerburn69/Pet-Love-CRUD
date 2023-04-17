package com.example.petlove.repository;

import com.example.petlove.entities.DichVu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface DichVuRepository extends MongoRepository<DichVu, String> {
    @Override
    Optional<DichVu> findById(String id);
    @Query(value = "{'maDichVu': ?0}")
    Optional<DichVu> getMaLoaiDichVu(String maDichVu);
    @Query(value = "{'maDichVu': ?0}", exists = true)
    boolean kiemTraMaDichVu(String maDichVu);
}
