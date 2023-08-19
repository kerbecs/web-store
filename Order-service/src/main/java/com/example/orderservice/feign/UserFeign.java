package com.example.orderservice.feign;

import com.example.orderservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE", path = "/api/v1/users")
public interface UserFeign {
    @GetMapping("/id/{id}")
    UserDto getUserById(@PathVariable Long id);
}
