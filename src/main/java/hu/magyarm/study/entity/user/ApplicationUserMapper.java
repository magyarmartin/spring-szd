package hu.magyarm.study.entity.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

    ApplicationUser applicationUserDtoToApplicationUser( final ApplicationUserDto userDto );

    ApplicationUserDto applicationUserToApplicationUserDto( final ApplicationUser user );

}