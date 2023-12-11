package com.FlySky.serviceTest;

import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.VueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.repository.IVueloRepository;
import com.FlySky.service.VueloServiceImp;
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
public class VueloServiceTest {

    @Mock
    IVueloRepository repository;

    @InjectMocks
    VueloServiceImp service;

    @Test
    void obtenerVuelosOkTest(){

        //ARRANGE

        List<VueloResponseDto> expected = listOfVuelosDto();

        when(repository.findAll()).thenReturn(listOfVuelosEntity());

        //ACT

        List<VueloResponseDto> actual = service.obtenerVuelos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerVuelosConAsientosDisponiblesOkTest(){

        //ARRANGE

        List<VueloResponseDto> expected = listOfVuelosDto();

        when(repository.findAll()).thenReturn(listOfVuelosEntity());

        //ACT

        List<VueloResponseDto> actual = service.obtenerVuelosConAsientosDisponibles();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerVueloByIdOkTest(){

        //ARRANGE

        VueloResponseDto expected = newVueloResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalVuelo());

        //ACT

        VueloResponseDto actual = service.obtenerVueloById(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarVueloOkTest(){

        //ARRANGE

        VueloRequestDto argumentSut = newVueloRequestDto();
        VueloResponseDto expected = newVueloResponseDto();

        when(repository.save(any())).thenReturn(newVuelo());

        //ACT

        VueloResponseDto actual = service.agregarVuelo(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarVueloOkTest(){

        //ARRANGE

        VueloRequestConIdDto argumentSut = newVueloRequestConIdDto();
        VueloResponseDto expected = newVueloResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalVuelo());
        when(repository.save(any())).thenReturn(newVuelo());

        //ACT

        VueloResponseDto actual = service.editarVuelo(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void borrarVueloOkTest(){

        //ARRANGE

        MensajeResponseDto expected = new MensajeResponseDto("borrado exitoso");
        when(repository.findById(anyLong())).thenReturn(newOptionalVuelo());

        //ACT

        MensajeResponseDto actual = service.borrarVuelo(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }
}
