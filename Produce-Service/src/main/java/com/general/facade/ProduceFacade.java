package com.general.facade;

import com.general.dto.ProduceDto;
import com.general.entity.Produce;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProduceFacade {
    List<ProduceDto> getAllProduces();

    ProduceDto getById(String id);

    List<ProduceDto> getByName(String name);

    List<ProduceDto> getByCountry(String country);

    ProduceDto save(ProduceDto produce);

    ProduceDto update(ProduceDto produce);

    void deleteById(String id);
}
