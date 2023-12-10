package com.FlySky.controllerTest;

import com.FlySky.controller.AsientoController;
import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.AsientoServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.FlySky.util.FactoryOfDtos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsientoControllerTest {

    @Mock
    AsientoServiceImp service;

    @InjectMocks
    AsientoController controller;

    @Test
    void obtenerAsientosOkTest(){

        //ARRANGE

        List<AsientoResponseDto> serviceResponse = listOfAsientosDto();

        ResponseEntity<List<AsientoResponseDto>> expected = new ResponseEntity<>(listOfAsientosDto(), HttpStatus.OK);

        when(service.obtenerAsientos()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<AsientoResponseDto>> actual = controller.obtenerAsientos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAsientosDisponiblesOkTest(){

        //ARRANGE

        List<AsientoResponseDto> serviceResponse = listOfAsientosDto();

        ResponseEntity<List<AsientoResponseDto>> expected = new ResponseEntity<>(listOfAsientosDto(), HttpStatus.OK);

        when(service.obtenerAsientosDisponibles()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<AsientoResponseDto>> actual = controller.obtenerAsientosDisponibles();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAsientosByIdOkTest(){

        //ARRANGE

        AsientoResponseDto serviceResponse = newAsientoResponseDto();

        ResponseEntity<AsientoResponseDto> expected = new ResponseEntity<>(newAsientoResponseDto(), HttpStatus.OK);

        when(service.obtenerAsientoById(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<AsientoResponseDto> actual = controller.obtenerAsientoById(1l);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarAsientoOkTest(){

        //ARRANGE

        AsientoRequestDto argumentSut = newAsientoRequestDto();
        AsientoResponseDto serviceResponse = newAsientoResponseDto();

        ResponseEntity<AsientoResponseDto> expected = new ResponseEntity<>(newAsientoResponseDto(), HttpStatus.OK);

        when(service.agregarAsiento(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<AsientoResponseDto> actual = controller.agregarAsiento(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);
    }

    @Test
    void editarAsientoOkTest(){

        //ARRANGE

        AsientoRequestConIdDto argumentSut = newAsientoRequestConIdDto();
        AsientoResponseDto serviceResponse = newAsientoResponseDto();

        ResponseEntity<AsientoResponseDto> expected = new ResponseEntity<>(newAsientoResponseDto(), HttpStatus.OK);

        when(service.editarAsiento(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<AsientoResponseDto> actual = controller.editarAsiento(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);
    }

    @Test
    void borrarAsientoOkTest(){

        //ARRANGE

        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.borrarAsiento(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.borrarAsiento(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

}
