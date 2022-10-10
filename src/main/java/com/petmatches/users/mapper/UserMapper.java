package com.petmatches.users.mapper;

import com.petmatches.users.dto.UserDto;
import com.petmatches.users.dto.UserResponseDto;
import com.petmatches.users.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserResponseDto userModelToUserResponseDto(UserModel userModel);

    UserModel userDtoToUserModel(UserDto userDto);

    List<UserResponseDto> listUserModelTOListUserResponseDto(List<UserModel>list);

}
