package com.FlySky.serviceTest;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.repository.IAerolineaRepository;
import com.FlySky.service.AerolineaServiceImp;
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
public class AerolineaServiceTest {

    @Mock
    IAerolineaRepository repository;

    @InjectMocks
    AerolineaServiceImp service;

    @Test
    void obtenerAerolineasOkTest(){

        //ARRANGE

        List<AerolineaResponseDto> expected = listOfAerolineasDto();

        when(repository.findAll()).thenReturn(listOfAerolineasEntity());

        //ACT

        List<AerolineaResponseDto> actual = service.obtenerAerolineas();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAerolineasSinVuelosOkTest(){

        //ARRANGE

        List<AerolineaSinVueloResponseDto> expected = listOfAerolineasSinVueloDto();

        when(repository.findAll()).thenReturn(listOfAerolineasEntity());

        //ACT

        List<AerolineaSinVueloResponseDto> actual = service.obtenerAerolineasSinVuelos();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerAerolineaByIdOkTest(){

        //ARRANGE

        AerolineaResponseDto expected = newAerolineaResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalAerolinea());

        //ACT

        AerolineaResponseDto actual = service.obtenerAerolineaById(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarAerolineaOkTest(){

        //ARRANGE

        AerolineaRequestDto argumentSut = newAerolineaRequestDto();
        AerolineaSinVueloResponseDto expected = newAerolineaSinVueloResponseDto();

        when(repository.save(any())).thenReturn(newAerolinea());

        //ACT

        AerolineaSinVueloResponseDto actual = service.agregarAerolinea(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void editarAerolineaOkTest(){

        //ARRANGE

        AerolineaRequestConIdDto argumentSut = newAerolineaRequestConIdDto();
        AerolineaSinVueloResponseDto expected = newAerolineaSinVueloResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalAerolinea());
        when(repository.save(any())).thenReturn(newAerolinea());

        //ACT

        AerolineaSinVueloResponseDto actual = service.editarAerolinea(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void borrarAerolineaOkTest(){

        //ARRANGE

        MensajeResponseDto expected = new MensajeResponseDto("borrado exitoso");
        when(repository.findById(anyLong())).thenReturn(newOptionalAerolinea());

        //ACT

        MensajeResponseDto actual = service.borrarAerolinea(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

}
