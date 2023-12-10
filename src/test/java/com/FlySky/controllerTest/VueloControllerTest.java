package com.FlySky.controllerTest;

import com.FlySky.controller.VueloController;
import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.dto.response.VueloResponseDto;
import com.FlySky.service.VueloServiceImp;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VueloControllerTest {

    @Mock
    VueloServiceImp service;

    @InjectMocks
    VueloController controller;

    @Test
    void obtenerVuelosOkTest(){

        //ARRANGE

        List<VueloResponseDto> serviceResponse = listOfVuelos();

        ResponseEntity<List<VueloResponseDto>> expected = new ResponseEntity<>(listOfVuelos(), HttpStatus.OK);

        when(service.obtenerVuelos()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<VueloResponseDto>> actual = controller.obtenerVuelos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerVuelosByNumeroAndAerolineaOkTest(){

        //ARRANGE

        VueloResponseDto serviceResponse = newVueloResponseDto();

        ResponseEntity<VueloResponseDto> expected = new ResponseEntity<>(newVueloResponseDto(), HttpStatus.OK);

        when(service.obtenerVueloByNumeroDeVueloAndAerolinea_Id(anyString(),anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<VueloResponseDto> actual = controller.obtenerVuelosByNumeroAndAerolinea("ARG001",1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerVuelosConAsientosDisponiblesOkTest(){

        //ARRANGE

        List<VueloResponseDto> serviceResponse = listOfVuelos();

        ResponseEntity<List<VueloResponseDto>> expected = new ResponseEntity<>(listOfVuelos(), HttpStatus.OK);

        when(service.obtenerVuelosConAsientosDisponibles()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<VueloResponseDto>> actual = controller.obtenerVuelosConAsientosDisponibles();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerVuelosByIdOkTest(){

        //ARRANGE

        VueloResponseDto serviceResponse = newVueloResponseDto();

        ResponseEntity<VueloResponseDto> expected = new ResponseEntity<>(newVueloResponseDto(), HttpStatus.OK);

        when(service.obtenerVueloById(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<VueloResponseDto> actual = controller.obtenerVueloById(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarVueloOkTest(){

        //ARRANGE

        VueloRequestDto argumentSut = newVueloRequestDto();
        VueloResponseDto serviceResponse = newVueloResponseDto();

        ResponseEntity<VueloResponseDto> expected = new ResponseEntity<>(newVueloResponseDto(), HttpStatus.OK);

        when(service.agregarVuelo(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<VueloResponseDto> actual = controller.agregarVuelo(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarVueloOkTest(){

        //ARRANGE

        VueloRequestConIdDto argumentSut = newVueloRequestConIdDto();
        VueloResponseDto serviceResponse = newVueloResponseDto();

        ResponseEntity<VueloResponseDto> expected = new ResponseEntity<>(newVueloResponseDto(), HttpStatus.OK);

        when(service.editarVuelo(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<VueloResponseDto> actual = controller.editarVuelo(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void borrarVueloOkTest(){

        //ARRANGE

        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.borrarVuelo(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.borrarVuelo(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }
}
