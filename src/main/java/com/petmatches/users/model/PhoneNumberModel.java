package com.petmatches.users.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumberModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "{com.petmatches.constraints.codeNationalityPhone.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.codeNationalityPhone.NotBlank.message}")
    @Pattern(regexp = "^.{2,5}$", message = "{com.petmatches.constraints.characterCodePhone.Pattern.message}")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "{com.petmatches.constraints.correctFormatPhone.Pattern.message}")
    @Column(name = "CODE")
    String code;

    @NotNull(message = "{com.petmatches.constraints.codeNationalityPhone.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.codeNationalityPhone.NotBlank.message}")
    @Pattern(regexp = "^([+]+[0-9]{2,5})+$", message = "{com.petmatches.constraints.countryCodePhone.Pattern.message}")
    @Column(name = "COUNTRY_CODE")
    String countryCode;

    @NotNull(message = "{com.petmatches.constraints.codeNationalityPhone.NotNull.message}")
    @NotBlank(message = "{com.petmatches.constraints.codeNationalityPhone.NotBlank.message}")
    @Pattern(regexp = "^([0-9\\s]){8,15}$", message = "{com.petmatches.constraints.phoneNumber.Pattern.message}")
    @Column(name = "NUMBER")
    String numberPhone;
}
