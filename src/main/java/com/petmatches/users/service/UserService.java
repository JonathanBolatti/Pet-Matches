package com.petmatches.users.service;

import com.petmatches.users.dto.RegisterUserDto;
import com.petmatches.users.dto.UserDto;
import com.petmatches.users.dto.UserResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserResponseDto getUserDetails(Long id);

    UserResponseDto saveUser(UserDto userDto);

    List<UserResponseDto> findAll(Pageable pageable);

    void registerUser(RegisterUserDto registerUserDto);

}
