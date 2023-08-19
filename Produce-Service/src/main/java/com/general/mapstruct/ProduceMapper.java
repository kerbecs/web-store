package com.general.mapstruct;

import com.general.dto.ProduceDto;
import com.general.entity.Produce;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduceMapper {
    ProduceDto produceToProduceDto(Produce produce);

    Produce produceDtoToProduce(ProduceDto produceDto);
}
