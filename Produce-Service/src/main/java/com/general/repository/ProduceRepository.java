package com.general.repository;

import com.general.entity.Produce;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProduceRepository extends MongoRepository<Produce, String> {
    List<Produce> findByName(String name);

    List<Produce> findByCountry(String country);
}
