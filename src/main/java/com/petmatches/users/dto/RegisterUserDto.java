package com.petmatches.users.dto;


import com.petmatches.users.model.NationalityModel;
import com.petmatches.users.model.PhoneNumberModel;
import com.petmatches.users.model.UserModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@Matches(field = "password", verifyField = "passwordCheck", message = "{com.dividenz.constraints.passwordEquals.message}")
@Validated
public class RegisterUserDto {

    @NotNull(message = "{com.petmatches.constraints.name.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.name.NotBlank.message}")
    @Size(min = 3, max = 20, message = "{com.petmatches.constraints.name.Size.message}")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "{com.petmatches.constraints.name.Pattern.message}")
    private String firstName;

    @NotNull(message = "{com.petmatches.constraints.lastName.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.lastName.NotBlank.message}")
    @Size(min = 3, max = 20, message = "{com.petmatches.constraints.lastName.Size.message}")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "{com.petmatches.constraints.lastName.Pattern.message}")
    private String lastName;

    @NotNull(message = "{com.petmatches.constraints.birthDate.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.birthDate.NotBlank.message}")
    @Pattern(regexp = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{4})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-3]\\d)?\\d{4})$", message = "{com.dividenz.constraints.birthDate.Pattern.message}")
    private String birthDate;

    @Valid
    private NationalityModel nationality;

    @Pattern(regexp = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z]{2,6}+)*(\\.[A-Za-z]{2,4})$"),
            message = "{com.petmatches.constraints.email.incorrectFormat.message}")
    @NotNull(message = "{com.petmatches.constraints.email.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.email.NotBlank.message}")
    private String email;

    @NotNull(message = "{com.petmatches.constraints.password.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.password.NotBlank.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^!\"`'#%&,:;<>=@{}~¿\\$\\(\\)\\*\\+\\/\\\\\\?\\[\\]\\^\\|]).{8,15}$", message = "{com.dividenz.constraints.passwordIncorrect.Pattern.message}")
    private String password;

    @NotNull(message = "{com.petmatches.constraints.password.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.password.NotBlank.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^!\"`'#%&,:;<>=@{}~¿\\$\\(\\)\\*\\+\\/\\\\\\?\\[\\]\\^\\|]).{8,15}$", message = "{com.dividenz.constraints.passwordIncorrect.Pattern.message}")
    private String passwordCheck;

    @Valid
    private PhoneNumberModel phoneNumber;

    private Set<String> roles = new HashSet<>();


    public static UserModel toUserModel(RegisterUserDto registerUserDto) {
        return UserModel.builder()
                .firstName(registerUserDto.firstName)
                .lastName(registerUserDto.lastName)
                .birthDate((registerUserDto.birthDate))
                .userNationality(registerUserDto.getNationality().getLabel())
                .codeNationality(registerUserDto.getNationality().getValue())
                .username(registerUserDto.email)
                .password(registerUserDto.password)
                .phoneNumber(new PhoneNumberModel(registerUserDto.getPhoneNumber().getId(), registerUserDto.getPhoneNumber().getCode(),
                        registerUserDto.getPhoneNumber().getCountryCode(), registerUserDto.getPhoneNumber().getNumberPhone()))
                .roles(null)
                .build();

    }

}
