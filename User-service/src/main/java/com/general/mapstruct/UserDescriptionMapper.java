package com.general.mapstruct;

import com.general.dto.UserDescriptionDto;
import com.general.entity.UserDescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDescriptionMapper {
    UserDescriptionDto userDescriptionToUserDto(UserDescription userDescription);

    UserDescription userDescriptionDtoToUserDescription(UserDescriptionDto userDescriptionDto);
}
