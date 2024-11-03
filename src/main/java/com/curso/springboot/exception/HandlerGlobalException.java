package com.curso.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerGlobalException {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomeErrorResponse> handleModelNotFoundException(ModelNotFoundException e, WebRequest request){
        CustomeErrorResponse customeErrorResponse = new CustomeErrorResponse(LocalDateTime.now(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customeErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomeErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
        String message= e.getBindingResult().getFieldErrors().stream()
                .map(error-> error.getField()+": "+error.getDefaultMessage()).collect(Collectors.joining(","));

        CustomeErrorResponse customeErrorResponse = new CustomeErrorResponse(LocalDateTime.now(), message, request.getDescription(false));

        return new ResponseEntity<>(customeErrorResponse, HttpStatus.NOT_FOUND);
    }
}
