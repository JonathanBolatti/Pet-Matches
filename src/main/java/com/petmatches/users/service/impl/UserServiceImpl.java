package com.petmatches.users.service.impl;

import com.petmatches.users.dto.RegisterUserDto;
import com.petmatches.users.dto.UserDto;
import com.petmatches.users.dto.UserResponseDto;
import com.petmatches.users.enums.RolName;
import com.petmatches.users.mapper.UserMapper;
import com.petmatches.users.model.CodeConfirmModel;
import com.petmatches.users.model.PhoneNumberModel;
import com.petmatches.users.model.RoleModel;
import com.petmatches.users.model.UserModel;
import com.petmatches.users.repository.CodeConfirmRepository;
import com.petmatches.users.repository.PhoneNumberRepository;
import com.petmatches.users.repository.RoleRepository;
import com.petmatches.users.repository.UserRepository;
import com.petmatches.users.service.RolService;
import com.petmatches.users.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RolService rolService;
    @Autowired
    PhoneNumberRepository phoneNumberRepository;
    @Autowired
    CodeConfirmRepository codeConfirmRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDto> findAll(Pageable pageable) {
        var userList = userRepository.findAll();
        return userMapper.listUserModelTOListUserResponseDto(userList);
    }

    @Override
    public void registerUser(RegisterUserDto registerUserDto) {
        if (userRepository.existsByUsername(registerUserDto.getEmail())) {
            throw new RuntimeException();
        }

        var newUser = RegisterUserDto.toUserModel(registerUserDto);
        newUser.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        Set<RoleModel> roles = new HashSet<>();
        roles.add(rolService.getByNameRole(RolName.ROLE_USER).orElseThrow());
        if (registerUserDto.getRoles().contains("admin"))
            roles.add(rolService.getByNameRole(RolName.ROLE_ADMIN).orElseThrow());

        newUser.setRoles(roles);

        PhoneNumberModel phoneNumber = newUser.getPhoneNumber();
        phoneNumberRepository.save(phoneNumber);

        userRepository.save(newUser);

//        creamos el codigo para la confirmacion de la cuenta
        var codeString = UUID.randomUUID().toString();
        var code = CodeConfirmModel.builder().code(codeString).registerDate(Calendar.getInstance()).status(true)
                .email(newUser.getUsername()).build();
        codeConfirmRepository.save(code);
        log.debug("Intento de crear usuario '{}'", registerUserDto);

    }

    @Override
    public UserResponseDto getUserDetails(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            var userResponseDto = userMapper.userModelToUserResponseDto(user.get());
            log.info("Devolviendo el usuario encontrado -> '{}'", user.get().getUsername());
            return userResponseDto;
        } else {
            log.error("usuario no encontrado, el id es incorrecto o no existe");
            throw new RuntimeException();
        }
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        var userSave = userMapper.userDtoToUserModel(userDto);
        var userSaved = userRepository.save(userSave);
        return userMapper.userModelToUserResponseDto(userSaved);
    }


}
