package com.petmatches.users.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class APIErrorDto<T> extends ApiResponseDto<T>{

    private List<String> errors;

    @Builder(builderMethodName = "Builder")
    public APIErrorDto(T data, String message, HttpStatus status, List<String> errors) {
        super(data, message, status, status.value());
        this.errors = errors;
    }

    public static <T> APIErrorDto<T> created(T data, String message, HttpStatus status, List<String> errors) {

        return new APIErrorDto<T>(data, message, status, errors);

    }

    public static <T> APIErrorDto<T> created(String message, HttpStatus status, List<String> errors) {

        return new APIErrorDto<T>(null, message, status, errors);

    }


}
