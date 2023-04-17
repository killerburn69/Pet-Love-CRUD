package com.example.petlove.repository;

import com.example.petlove.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan,String> {
    @Override
    Optional<TaiKhoan> findById(String id);

    @Query(value = "{'email': ?0}")
    Optional<TaiKhoan> getUser(String email);

    @Query(value = "{'email': ?0}", exists = true)
    boolean kiemTraEmail(String email);
}
