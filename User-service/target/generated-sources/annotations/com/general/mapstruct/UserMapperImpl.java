package com.general.mapstruct;

import com.general.dto.UserDescriptionDto;
import com.general.dto.UserDto;
import com.general.entity.User;
import com.general.entity.UserDescription;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-19T16:26:14+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.username( user.getUsername() );
        userDto.isActive( user.getIsActive() );
        userDto.userDescription( userDescriptionToUserDescriptionDto( user.getUserDescription() ) );

        return userDto.build();
    }

    @Override
    public User UserDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.username( userDto.getUsername() );
        user.password( userDto.getPassword() );
        user.isActive( userDto.getIsActive() );
        user.userDescription( userDescriptionDtoToUserDescription( userDto.getUserDescription() ) );

        return user.build();
    }

    protected UserDescriptionDto userDescriptionToUserDescriptionDto(UserDescription userDescription) {
        if ( userDescription == null ) {
            return null;
        }

        UserDescriptionDto.UserDescriptionDtoBuilder userDescriptionDto = UserDescriptionDto.builder();

        if ( userDescription.getId() != null ) {
            userDescriptionDto.id( userDescription.getId().intValue() );
        }
        userDescriptionDto.firstName( userDescription.getFirstName() );
        userDescriptionDto.lastName( userDescription.getLastName() );
        userDescriptionDto.email( userDescription.getEmail() );
        userDescriptionDto.city( userDescription.getCity() );
        userDescriptionDto.address( userDescription.getAddress() );

        return userDescriptionDto.build();
    }

    protected UserDescription userDescriptionDtoToUserDescription(UserDescriptionDto userDescriptionDto) {
        if ( userDescriptionDto == null ) {
            return null;
        }

        UserDescription.UserDescriptionBuilder userDescription = UserDescription.builder();

        if ( userDescriptionDto.getId() != null ) {
            userDescription.id( userDescriptionDto.getId().longValue() );
        }
        userDescription.firstName( userDescriptionDto.getFirstName() );
        userDescription.lastName( userDescriptionDto.getLastName() );
        userDescription.email( userDescriptionDto.getEmail() );
        userDescription.city( userDescriptionDto.getCity() );
        userDescription.address( userDescriptionDto.getAddress() );

        return userDescription.build();
    }
}
