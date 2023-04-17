package com.example.petlove.repository;

import com.example.petlove.entities.DatCho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DatChoRepository extends MongoRepository<DatCho,String> {
}
