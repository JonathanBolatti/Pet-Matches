package com.petmatches.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ApiResponseDto<T> {

        private T data;
        private String message;
        private HttpStatus status;
        private int statusCode;

        public static <T> ApiResponseDto<T> created(T data, String message, HttpStatus status) {
            return new ApiResponseDto<T>(data, message, status, status.value());
        }

        public static <T> ApiResponseDto<T> created(String message, HttpStatus status) {
            return new ApiResponseDto<T>(null, message, status, status.value());
        }
    }
