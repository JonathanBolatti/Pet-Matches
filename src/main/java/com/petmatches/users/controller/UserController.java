package com.petmatches.users.controller;

import com.petmatches.users.dto.RegisterUserDto;
import com.petmatches.users.dto.UserDto;
import com.petmatches.users.dto.UserResponseDto;
import com.petmatches.users.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    /* ============================================================ */
    /*                          ABM-USER                            */
    /* ============================================================ */

    @GetMapping("/list")
    public ResponseEntity<?> listar(Pageable pageable) {
        return ResponseEntity.ok().body(userService.findAll(pageable));
    }

    @GetMapping("/me/{id}")
    public UserResponseDto getUserDetails(@PathVariable Long id) {
        return this.userService.getUserDetails(id);
    }

    @PostMapping("/save")
    public UserResponseDto saveUser(@RequestBody UserDto userDto){
        return this.userService.saveUser(userDto);
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDto registerUserDto) {
        this.userService.registerUser(registerUserDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }




}
