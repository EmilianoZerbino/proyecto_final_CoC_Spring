package com.FlySky.controllerTest;

import com.FlySky.controller.ReservaController;
import com.FlySky.dto.request.AbordarVueloRequestDto;
import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.HistorialClienteResponseDto;
import com.FlySky.dto.response.HistorialDiarioResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.dto.response.ReservaResponseDto;
import com.FlySky.service.ReservaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static com.FlySky.util.FactoryOfDtos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservaControllerTest {

    @Mock
    ReservaServiceImp service;

    @InjectMocks
    ReservaController controller;


    @Test
    void obtenerReservasOkTest(){

        //ARRANGE

        List<ReservaResponseDto> serviceResponse = listOfReservas();

        ResponseEntity<List<ReservaResponseDto>> expected = new ResponseEntity<>(listOfReservas(), HttpStatus.OK);

        when(service.obtenerReservas()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<ReservaResponseDto>> actual = controller.obtenerReservas();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerReservasByIdOkTest(){

        //ARRANGE

        ReservaResponseDto serviceResponse = newReservaResponseDto();

        ResponseEntity<ReservaResponseDto> expected = new ResponseEntity<>(newReservaResponseDto(), HttpStatus.OK);

        when(service.obtenerReservaById(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<ReservaResponseDto> actual = controller.obtenerReservaById(1l);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerReservasByClienteOkTest(){

        //ARRANGE

        HistorialClienteResponseDto serviceResponse = newHistorialClienteResponseDto();

        ResponseEntity<HistorialClienteResponseDto> expected = new ResponseEntity<>(newHistorialClienteResponseDto(), HttpStatus.OK);

        when(service.obtenerReservaByCliente(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<HistorialClienteResponseDto> actual = controller.obtenerReservaByCliente(1l);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerResumenDiarioOkTest(){

        //ARRANGE

        HistorialDiarioResponseDto serviceResponse = newHistorialDiarioResponseDto();

        ResponseEntity<HistorialDiarioResponseDto> expected = new ResponseEntity<>(newHistorialDiarioResponseDto(), HttpStatus.OK);

        when(service.obtenerResumenDiario(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<HistorialDiarioResponseDto> actual = controller.obtenerResumenDiario(LocalDate.of(2023,12,12));

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarReservaOkTest(){

        //ARRANGE

        ReservaRequestDto argumentSut = newReservaRequestDto();
        ReservaResponseDto serviceResponse = newReservaResponseDto();

        ResponseEntity<ReservaResponseDto> expected = new ResponseEntity<>(newReservaResponseDto(), HttpStatus.OK);

        when(service.agregarReserva(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<ReservaResponseDto> actual = controller.agregarReserva(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void abordarVueloOkTest(){

        //ARRANGE

        AbordarVueloRequestDto argumentSut = newAbordarVueloRequestDto();
        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.abordarVuelo((any()))).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.abordarVuelo(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void cancelarReservaOkTest(){

        //ARRANGE

        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.cancelarReserva(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.cancelarReserva(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarReservaOkTest(){

        //ARRANGE

        ReservaRequestConIdDto argumentSut = newReservaRequestConIdDto();
        ReservaResponseDto serviceResponse = newReservaResponseDto();

        ResponseEntity<ReservaResponseDto> expected = new ResponseEntity<>(newReservaResponseDto(), HttpStatus.OK);

        when(service.editarReserva(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<ReservaResponseDto> actual = controller.editarReserva(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);
    }

    @Test
    void borrarReservaOkTest(){

        //ARRANGE

        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.borrarReserva(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.borrarReserva(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }


}
