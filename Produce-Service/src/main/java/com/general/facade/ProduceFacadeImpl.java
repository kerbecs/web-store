package com.general.facade;

import com.general.controller.ProduceController;
import com.general.dto.ProduceDto;
import com.general.entity.Produce;
import com.general.mapstruct.ProduceMapper;
import com.general.service.ProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class ProduceFacadeImpl implements ProduceFacade {
    private final ProduceService produceService;
    private final ProduceMapper produceMapper;

    @Override
    public List<ProduceDto> getAllProduces() {
        return produceService.getAllProduces()
                .stream()
                .map(produceMapper::produceToProduceDto)
                .map(this::addLinks)
                .toList();
    }

    @Override
    public ProduceDto getById(String id) {
        return addLinks(produceMapper.produceToProduceDto(produceService.getById(id)));
    }

    @Override
    public List<ProduceDto> getByName(String name) {
        return produceService.getByName(name)
                .stream()
                .map(produceMapper::produceToProduceDto)
                .map(this::addLinks)
                .toList();
    }

    @Override
    public List<ProduceDto> getByCountry(String country) {
        return produceService.getByCountry(country)
                .stream()
                .map(produceMapper::produceToProduceDto)
                .map(this::addLinks)
                .toList();
    }

    @Override
    public ProduceDto save(ProduceDto produceDto) {
        Produce produce = produceMapper.produceDtoToProduce(produceDto);
        Produce savedProduce = produceService.save(produce);

        return addLinks(produceMapper.produceToProduceDto(savedProduce));
    }

    @Override
    public ProduceDto update(ProduceDto produceDto) {
        Produce produce = produceMapper.produceDtoToProduce(produceDto);
        produce.setId(null);
        Produce savedProduce = produceService.save(produce);

        return addLinks(produceMapper.produceToProduceDto(savedProduce));
    }

    @Override
    public void deleteById(String id) {
        produceService.getById(id);

        produceService.getById(id);
    }

    private ProduceDto addLinks(ProduceDto produceDto) {
        produceDto.add(
                linkTo(methodOn(ProduceController.class).getAllProduces()).withRel("All"),
                linkTo(methodOn(ProduceController.class).getByName(produceDto.getName())).withRel("Name"),
                linkTo(methodOn(ProduceController.class).getById(produceDto.getId())).withRel("Id"),
                linkTo(methodOn(ProduceController.class).getByCountry(produceDto.getCountry())).withRel("Country")
        );

        return produceDto;
    }
}
