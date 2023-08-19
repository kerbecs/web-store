package com.general.facade;

import com.general.dto.UserDto;

import java.util.List;

public interface UserFacade {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto getUserByUsername(String username);
    UserDto save(UserDto userDto);
    UserDto update(UserDto userDto);
    void deleteById(Long id);
}
