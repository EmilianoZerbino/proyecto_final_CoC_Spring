package com.FlySky.exceptionTest;

import com.FlySky.dto.response.exception.ErrorDto;
import com.FlySky.exception.EntityAlreadyExistException;
import com.FlySky.exception.EntityNotFoundException;
import com.FlySky.exception.ExceptionController;
import com.FlySky.exception.InsertionDBException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionControllerTest {

    @Autowired
    ExceptionController exceptionController;

    @Test
    @DisplayName("Testeo de salida de EntityNotFoundException")
    void EntityNotFoundOkTest() {

        //ARRANGE

        ErrorDto body = new ErrorDto(404, "message");
        EntityNotFoundException argumentSut = new EntityNotFoundException("message");
        ResponseEntity<ErrorDto> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

        //ACT

        ResponseEntity<ErrorDto> actual = exceptionController.entityNotFound(argumentSut);

        //ASSERT

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Testeo de salida de EntityAlreadyExistException")
    void EntityAlreadyExistOkTest() {

        //ARRANGE

        ErrorDto body = new ErrorDto(400, "message");
        EntityAlreadyExistException argumentSut = new EntityAlreadyExistException("message");
        ResponseEntity<ErrorDto> expected = new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

        //ACT

        ResponseEntity<ErrorDto> actual = exceptionController.entityAlreadyExist(argumentSut);

        //ASSERT

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Testeo de salida de InsertionDBException")
    void InsertionDBOkTest() {

        //ARRANGE

        ErrorDto body = new ErrorDto(400, "message");
        InsertionDBException argumentSut = new InsertionDBException("message");
        ResponseEntity<ErrorDto> expected = new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

        //ACT

        ResponseEntity<ErrorDto> actual = exceptionController.InsertionDB(argumentSut);

        //ASSERT

        assertEquals(expected, actual);

    }

}
