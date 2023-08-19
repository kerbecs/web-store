package com.general.mapstruct;

import com.general.dto.UserDto;
import com.general.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    UserDto userToUserDto(User user);

    User UserDtoToUser(UserDto userDto);

}
