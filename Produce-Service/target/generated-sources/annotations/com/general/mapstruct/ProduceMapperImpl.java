package com.general.mapstruct;

import com.general.dto.ProduceDto;
import com.general.entity.Produce;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-19T15:04:14+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ProduceMapperImpl implements ProduceMapper {

    @Override
    public ProduceDto produceToProduceDto(Produce produce) {
        if ( produce == null ) {
            return null;
        }

        ProduceDto.ProduceDtoBuilder produceDto = ProduceDto.builder();

        produceDto.id( produce.getId() );
        produceDto.name( produce.getName() );
        produceDto.description( produce.getDescription() );
        produceDto.country( produce.getCountry() );
        produceDto.brand( produce.getBrand() );
        produceDto.price( produce.getPrice() );
        if ( produce.getDeliveryPrice() != null ) {
            produceDto.deliveryPrice( Double.parseDouble( produce.getDeliveryPrice() ) );
        }
        produceDto.quantity( produce.getQuantity() );

        return produceDto.build();
    }

    @Override
    public Produce produceDtoToProduce(ProduceDto produceDto) {
        if ( produceDto == null ) {
            return null;
        }

        Produce.ProduceBuilder produce = Produce.builder();

        produce.id( produceDto.getId() );
        produce.name( produceDto.getName() );
        produce.description( produceDto.getDescription() );
        produce.country( produceDto.getCountry() );
        produce.brand( produceDto.getBrand() );
        produce.price( produceDto.getPrice() );
        if ( produceDto.getDeliveryPrice() != null ) {
            produce.deliveryPrice( String.valueOf( produceDto.getDeliveryPrice() ) );
        }
        produce.quantity( produceDto.getQuantity() );

        return produce.build();
    }
}
