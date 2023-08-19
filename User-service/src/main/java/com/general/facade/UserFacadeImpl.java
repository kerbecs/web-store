package com.general.facade;

import com.general.controller.UserController;
import com.general.dto.UserDto;
import com.general.entity.User;
import com.general.mapstruct.UserMapper;
import com.general.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userMapper::userToUserDto)
                .map(this::addLinks)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        return addLinks(userMapper.userToUserDto(userService.getUserById(id)));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return addLinks(userMapper.userToUserDto(userService.getUserByUsername(username)));
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.UserDtoToUser(userDto);
        user.setId(null);
        user.getUserDescription().setId(null);
        User savedUser = userService.save(user);

        return addLinks(userMapper.userToUserDto(savedUser));
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userMapper.UserDtoToUser(userDto);
        User savedUser = userService.save(user);

        return addLinks(userMapper.userToUserDto(savedUser));
    }

    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    private UserDto addLinks(UserDto userDto) {
        userDto.add(linkTo(methodOn(UserController.class).getUserById(userDto.getId())).withRel("Id"),
                linkTo(methodOn(UserController.class).getUserByUsername(userDto.getUsername())).withRel("Username"),
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("Users"));

        return userDto;
    }
}
