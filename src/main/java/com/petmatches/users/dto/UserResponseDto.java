package com.petmatches.users.dto;

import lombok.Data;

@Data
public class UserResponseDto {

    private String username;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String userNationality;
    private String codeNationality;

}
