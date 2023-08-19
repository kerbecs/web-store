package com.general.service;

import com.general.entity.Produce;

import java.util.List;

public interface ProduceService {
    List<Produce> getAllProduces();

    Produce getById(String id);

    List<Produce> getByName(String name);

    List<Produce> getByCountry(String country);

    Produce save(Produce produce);

    void deleteById(String id);
}
