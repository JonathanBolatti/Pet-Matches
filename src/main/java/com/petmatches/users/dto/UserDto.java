package com.petmatches.users.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private String username;
    private String password;


    @NotNull(message = "{com.petmatches.constraints.name.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.name.NotBlank.message}")
    @Size(min = 3, max = 20, message = "{com.petmatches.constraints.name.Size.message}")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "{com.petmatches.constraints.name.Pattern.message}")
    private String firstName;


    private String lastName;

    private String birthDate;

    private String userNationality;

    private String codeNationality;

}
