package com.petmatches.users.exception;


import com.petmatches.users.dto.APIErrorDto;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handler for @Valid annotation
	 */

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {

		List<String> errors = getMessageErrors(ex.getBindingResult());

		var apiError = APIErrorDto.created(null, "The request contains errors.", HttpStatus.BAD_REQUEST, errors);

		return new ResponseEntity<>(apiError, headers, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	private List<String> getMessageErrors(BindingResult bindingResult) {

		List<String> errors = bindingResult
				.getFieldErrors()
				.stream()
				.map(x -> x.getField() + ": " + x.getDefaultMessage())
				.collect(Collectors.toList());

		errors.addAll(bindingResult
				.getGlobalErrors()
				.stream()
				.map(x -> x.getObjectName() + ": " + x.getDefaultMessage())
				.toList());

		return errors;

	}
}


