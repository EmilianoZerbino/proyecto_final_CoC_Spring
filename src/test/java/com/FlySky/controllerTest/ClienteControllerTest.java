package com.FlySky.controllerTest;

import com.FlySky.controller.ClienteController;
import com.FlySky.dto.request.ClienteRequestConIdDto;
import com.FlySky.dto.request.ClienteRequestDto;
import com.FlySky.dto.response.ClienteResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.ClienteServiceImp;
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
public class ClienteControllerTest {

    @Mock
    ClienteServiceImp service;

    @InjectMocks
    ClienteController controller;

    @Test
    void obtenerClientesOkTest(){

        //ARRANGE

        List<ClienteResponseDto> serviceResponse = listOfClientesDto();

        ResponseEntity<List<ClienteResponseDto>> expected = new ResponseEntity<>(listOfClientesDto(), HttpStatus.OK);

        when(service.obtenerClientes()).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<List<ClienteResponseDto>> actual = controller.obtenerClientes();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerClienteByIdOkTest(){

        //ARRANGE

        ClienteResponseDto serviceResponse = newClienteResponseDto();

        ResponseEntity<ClienteResponseDto> expected = new ResponseEntity<>(newClienteResponseDto(), HttpStatus.OK);

        when(service.obtenerClienteById(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<ClienteResponseDto> actual = controller.obtenerClienteById(1);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarClienteOkTest(){

        //ARRANGE

        ClienteRequestDto argumentSut = newClienteRequestDto();
        ClienteResponseDto serviceResponse = newClienteResponseDto();

        ResponseEntity<ClienteResponseDto> expected = new ResponseEntity<>(newClienteResponseDto(), HttpStatus.OK);

        when(service.agregarCliente(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<ClienteResponseDto> actual = controller.agregarCliente(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarClienteOkTest(){

        //ARRANGE

        ClienteRequestConIdDto argumentSut = newClienteRequestConIdDto();
        ClienteResponseDto serviceResponse = newClienteResponseDto();

        ResponseEntity<ClienteResponseDto> expected = new ResponseEntity<>(newClienteResponseDto(), HttpStatus.OK);

        when(service.editarCliente(any())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<ClienteResponseDto> actual = controller.editarCliente(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);
    }

    @Test
    void borrarClienteOkTest(){

        //ARRANGE

        MensajeResponseDto serviceResponse = new MensajeResponseDto("message");

        ResponseEntity<MensajeResponseDto> expected = new ResponseEntity<>(new MensajeResponseDto("message"), HttpStatus.OK);

        when(service.borrarCliente(anyLong())).thenReturn(serviceResponse);

        //ACT

        ResponseEntity<MensajeResponseDto> actual = controller.borrarCliente(1L);

        //ASSERTS

        assertEquals(expected,actual);
    }

}
