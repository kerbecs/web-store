package com.example.orderservice.feign;

import com.example.orderservice.dto.ProduceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCE-SERVICE", path = "/api/v1/produces")
public interface ProduceFeign {
    @GetMapping("/id/{id}")
    ProduceDto getById(@PathVariable("id") String id);
}
