package com.FlySky.controllerTest;

import com.FlySky.controller.AerolineaController;
import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.AerolineaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.FlySky.util.FactoryOfObjects.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AerolineaControllerTest {

    @Mock
    AerolineaServiceImp service;

    @InjectMocks
    AerolineaController controller;

    @Test
    void obtenerAerolineasOkTest(){

        //ARRANGE

        List<AerolineaResponseDto> serviceResponse = listOfAerolineas();

        ResponseEntity<List<AerolineaResponseDto>> expected = new ResponseEntity<>(listOfAerolineas(), HttpStatus.OK);

        when(service.obtenerAerolineas()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<AerolineaResponseDto>> actual = controller.obtenerAerolineas();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAerolineasSinVuelosOkTest(){

        //ARRANGE

        List<AerolineaSinVueloResponseDto> serviceResponse = listOfAerolineasSinVuelo();

        ResponseEntity<List<AerolineaSinVueloResponseDto>> expected = new ResponseEntity<>(listOfAerolineasSinVuelo(), HttpStatus.OK);

        when(service.obtenerAerolineasSinVuelos()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<AerolineaSinVueloResponseDto>> actual = controller.obtenerAerolineasSinVuelos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAerolineaByIdOkTest(){

        //ARRANGE

        AerolineaResponseDto serviceResponse = newAerolineaResponseDto();

        ResponseEntity<AerolineaResponseDto> expected = new ResponseEntity<>(newAerolineaResponseDto(), HttpStatus.OK);

        when(service.obtenerAerolineaById(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<AerolineaResponseDto> actual = controller.obtenerAerolineaById(1);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarAerolineaOkTest(){

        //ARRANGE

        AerolineaRequestDto argumentSut = newAerolineaRequestDto();
        AerolineaSinVueloResponseDto serviceResponse = newAerolineaSinVueloResponseDto();

        ResponseEntity<AerolineaSinVueloResponseDto> expected = new ResponseEntity<>(newAerolineaSinVueloResponseDto(), HttpStatus.OK);

        when(service.agregarAerolinea(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<AerolineaSinVueloResponseDto> actual = controller.agregarAerolinea(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarAerolineaOkTest(){

        //ARRANGE

        AerolineaRequestConIdDto argumentSut = newAerolineaRequestConIdDto();
        AerolineaSinVueloResponseDto serviceResponse = newAerolineaSinVueloResponseDto();

        ResponseEntity<AerolineaSinVueloResponseDto> expected = new ResponseEntity<>(newAerolineaSinVueloResponseDto(), HttpStatus.OK);

        when(service.editarAerolinea(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<AerolineaSinVueloResponseDto> actual = controller.editarAerolinea(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);
    }

    @Test
    void borrarAerolineaOkTest(){

        //ARRANGE

        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.borrarAerolinea(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.borrarAerolinea(1L);

        //ASSERTS

        assertEquals(expected,actual);
    }
}
