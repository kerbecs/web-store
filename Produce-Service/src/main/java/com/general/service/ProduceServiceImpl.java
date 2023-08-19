package com.general.service;

import com.general.entity.Produce;
import com.general.exception.NoSuchElementException;
import com.general.repository.ProduceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduceServiceImpl implements ProduceService {
    private final ProduceRepository produceRepository;

    @Override
    public List<Produce> getAllProduces() {
        return produceRepository.findAll();
    }

    @Override
    public Produce getById(String id) {
        return produceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produce with id " + id + " does not exist"));
    }

    @Override
    public List<Produce> getByName(String name) {
        return produceRepository.findByName(name);
    }

    @Override
    public List<Produce> getByCountry(String country) {
        return produceRepository.findByCountry(country);
    }

    @Override
    public Produce save(Produce produce) {
        return produceRepository.save(produce);
    }

    @Override
    public void deleteById(String id) {
        produceRepository.deleteById(id);
    }
}
