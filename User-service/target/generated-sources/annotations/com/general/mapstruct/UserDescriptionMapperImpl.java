package com.general.mapstruct;

import com.general.dto.UserDescriptionDto;
import com.general.entity.UserDescription;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-19T16:26:14+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class UserDescriptionMapperImpl implements UserDescriptionMapper {

    @Override
    public UserDescriptionDto userDescriptionToUserDto(UserDescription userDescription) {
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

    @Override
    public UserDescription userDescriptionDtoToUserDescription(UserDescriptionDto userDescriptionDto) {
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
