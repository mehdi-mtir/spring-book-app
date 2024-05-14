package com.bna.booksapp.mappers;

import com.bna.booksapp.dtos.SignUpDto;
import com.bna.booksapp.dtos.UserDto;
import com.bna.booksapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpDtoToUser(SignUpDto signUpDto);
}
