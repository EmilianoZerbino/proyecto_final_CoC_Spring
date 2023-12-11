package com.FlySky.serviceTest;

import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.repository.IAsientoRepository;
import com.FlySky.service.AsientoServiceImp;
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
public class AsientoServiceTest {

    @Mock
    IAsientoRepository repository;

    @InjectMocks
    AsientoServiceImp service;

    @Test
    void obtenerAsientosOkTest(){

        //ARRANGE

        List<AsientoResponseDto> expected = listOfAsientosDto();

        when(repository.findAll()).thenReturn(listOfAsientosEntity());

        //ACT

        List<AsientoResponseDto> actual = service.obtenerAsientos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAsientosDisponiblesOkTest(){

        //ARRANGE

        List<AsientoResponseDto> expected = listOfAsientosDto();

        when(repository.findAll()).thenReturn(listOfAsientosEntity());

        //ACT

        List<AsientoResponseDto> actual = service.obtenerAsientos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAsientoByIdOkTest(){

        //ARRANGE

        AsientoResponseDto expected = newAsientoResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalAsiento());

        //ACT

        AsientoResponseDto actual = service.obtenerAsientoById(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarAsientoOkTest(){

        //ARRANGE

        AsientoRequestDto argumentSut = newAsientoRequestDto();
        AsientoResponseDto expected = newAsientoResponseDto();

        when(repository.save(any())).thenReturn(newAsiento());

        //ACT

        AsientoResponseDto actual = service.agregarAsiento(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarAsientoOkTest(){

        //ARRANGE

        AsientoRequestConIdDto argumentSut = newAsientoRequestConIdDto();
        AsientoResponseDto expected = newAsientoResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalAsiento());
        when(repository.save(any())).thenReturn(newAsiento());

        //ACT

        AsientoResponseDto actual = service.editarAsiento(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void borrarAsientoOkTest(){

        //ARRANGE

        MensajeResponseDto expected = new MensajeResponseDto("borrado exitoso");
        when(repository.findById(anyLong())).thenReturn(newOptionalAsiento());

        //ACT

        MensajeResponseDto actual = service.borrarAsiento(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

}
