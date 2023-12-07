package com.FlySky.exception;

import com.FlySky.dto.response.exception.ErrorValidationDto;
import com.FlySky.dto.response.exception.ErrorDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> entityNotFound(EntityNotFoundException ex){
        return new ResponseEntity<>(new ErrorDto(404,ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ErrorDto> entityAlreadyExist(EntityAlreadyExistException ex){
        return new ResponseEntity<>(new ErrorDto(400,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsertionDBException.class)
    public ResponseEntity<ErrorDto> InsertionDB(InsertionDBException ex){
        return new ResponseEntity<>(new ErrorDto(400,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationDto> validationFailure(MethodArgumentNotValidException ex){
        HashMap<String,String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(field -> errors.put(field.getField(),field.getDefaultMessage()));
        return new ResponseEntity<>(new ErrorValidationDto(400,errors), HttpStatus.BAD_REQUEST);
    }

}