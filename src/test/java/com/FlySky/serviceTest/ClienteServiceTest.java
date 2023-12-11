package com.FlySky.serviceTest;

import com.FlySky.dto.request.ClienteRequestConIdDto;
import com.FlySky.dto.request.ClienteRequestDto;
import com.FlySky.dto.response.ClienteResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.repository.IClienteRepository;
import com.FlySky.service.ClienteServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.FlySky.util.FactoryOfDtos.*;
import static com.FlySky.util.FactoryOfEntities.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    IClienteRepository repository;

    @InjectMocks
    ClienteServiceImp service;

    @Test
    void obtenerClientesOkTest(){

        //ARRANGE

        List<ClienteResponseDto> expected = listOfClientesDto();

        when(repository.findAll()).thenReturn(listOfClientesEntity());

        //ACT

        List<ClienteResponseDto> actual = service.obtenerClientes();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerClienteByIdOkTest(){

        //ARRANGE

        ClienteResponseDto expected = newClienteResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalCliente());

        //ACT

        ClienteResponseDto actual = service.obtenerClienteById(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarClienteOkTest(){

        //ARRANGE

        ClienteRequestDto argumentSut = newClienteRequestDto();
        ClienteResponseDto expected = newClienteResponseDto();

        when(repository.save(any())).thenReturn(newCliente());

        //ACT

        ClienteResponseDto actual = service.agregarCliente(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarClienteOkTest(){

        //ARRANGE

        ClienteRequestConIdDto argumentSut = newClienteRequestConIdDto();
        ClienteResponseDto expected = newClienteResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalCliente());
        when(repository.save(any())).thenReturn(newCliente());

        //ACT

        ClienteResponseDto actual = service.editarCliente(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void borrarClienteOkTest(){

        //ARRANGE

        MensajeResponseDto expected = new MensajeResponseDto("borrado exitoso");
        when(repository.findById(anyLong())).thenReturn(newOptionalCliente());

        //ACT

        MensajeResponseDto actual = service.borrarCliente(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

}
