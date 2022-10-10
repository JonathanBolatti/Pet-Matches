package com.petmatches.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class NationalityModel {

    //	Code Nationality
    @Pattern(regexp = "^.{2,5}$", message = "{com.petmatches.constraints.sizeCharacterValue.Pattern.message}")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "{com.petmatches.constraints.correctFormat.Pattern.message}")
    private String value;

    //	Name Nationality
    @Pattern(regexp = "^.{3,15}$", message = "{com.petmatches.constraints.sizeCharacterLabel.Pattern.message}")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "{com.petmatches.constraints.correctFormat.Pattern.message}")
    private String label;
}
