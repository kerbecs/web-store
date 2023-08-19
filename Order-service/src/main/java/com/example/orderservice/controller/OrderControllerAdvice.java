package com.example.orderservice.controller;


import com.example.orderservice.exception.BodyError;
import com.example.orderservice.exception.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationError(MethodArgumentNotValidException exception) {
        Map<String, String> map = new HashMap<>();

        exception.getBindingResult()
                .getAllErrors()
                .forEach(err -> {
                            String field = ((FieldError) err).getField();
                            String message = err.getDefaultMessage();

                            map.put(field, message);
                        }
                );

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<BodyError> noElement(NoSuchElementException exception, WebRequest webRequest) {
        BodyError bodyError = BodyError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .timestamp(System.currentTimeMillis())
                .path(webRequest.getDescription(false))
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(bodyError, HttpStatus.BAD_REQUEST);
    }

}
