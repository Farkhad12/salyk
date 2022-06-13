package com.testApp.salyk.mappers;

import com.testApp.salyk.models.dtos.UserDto;
import com.testApp.salyk.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToUser(UserDto userDtoDto);

    UserDto mapToUserDto(User user);
}
