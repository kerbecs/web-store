package com.example.orderservice.mapstruct;

import com.example.orderservice.dto.OrderDtoGet;
import com.example.orderservice.dto.OrderDtoSave;
import com.example.orderservice.dto.ProduceDto;
import com.example.orderservice.dto.UserDto;
import com.example.orderservice.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderDtoSaveToOrder(OrderDtoSave orderDtoSave);

    OrderDtoSave orderToOrderDtoSave(Order order);

    default OrderDtoGet orderToOrderDtoGet(Order order, UserDto user, ProduceDto produce) {
        return OrderDtoGet.builder()
                .id(order.getId())
                .timeOrder(order.getTimeOrder())
                .user(user)
                .produce(produce)
                .build();
    }
}
