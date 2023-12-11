package com.FlySky.serviceTest;

import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.HistorialClienteResponseDto;
import com.FlySky.dto.response.HistorialDiarioResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.dto.response.ReservaResponseDto;
import com.FlySky.repository.IAsientoRepository;
import com.FlySky.repository.IClienteRepository;
import com.FlySky.repository.IReservaRepository;
import com.FlySky.service.ReservaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static com.FlySky.util.FactoryOfDtos.*;
import static com.FlySky.util.FactoryOfEntities.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @Mock
    IReservaRepository repository;

    @Mock
    IAsientoRepository asientoRepository;

    @Mock
    IClienteRepository clienteRepository;

    @InjectMocks
    ReservaServiceImp service;

    @Test
    void obtenerReservasOkTest(){

        //ARRANGE

        List<ReservaResponseDto> expected = listOfReservasDto();

        when(repository.findAll()).thenReturn(listOfReservasEntity());

        //ACT

        List<ReservaResponseDto> actual = service.obtenerReservas();

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerReservaByIdOkTest(){

        //ARRANGE

        ReservaResponseDto expected = newReservaResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalReserva());

        //ACT

        ReservaResponseDto actual = service.obtenerReservaById(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerReservaByClienteOkTest(){

        //ARRANGE

        HistorialClienteResponseDto expected = newHistorialClienteResponseDto();

        when(repository.findByCliente_Id(anyLong())).thenReturn(listOfReservasEntity());
        when(clienteRepository.findById(anyLong())).thenReturn(newOptionalCliente());

        //ACT

        HistorialClienteResponseDto actual = service.obtenerReservaByCliente(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void obtenerResumenDiarioOkTest(){

        //ARRANGE

        HistorialDiarioResponseDto expected = newHistorialDiarioResponseDto();

        when(repository.findByFechaVenta(any())).thenReturn(listOfReservasEntity());

        //ACT

        HistorialDiarioResponseDto actual = service.obtenerResumenDiario(LocalDate.of(2023,12,12));

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void agregarReservaOkTest(){

        //ARRANGE

        ReservaRequestDto argumentSut = newReservaRequestDto();
        ReservaResponseDto expected = newReservaResponseDto();

        when(repository.save(any())).thenReturn(newReserva());
        when(clienteRepository.findById(anyLong())).thenReturn(newOptionalCliente());
        when(asientoRepository.findById(anyLong())).thenReturn(newOptionalAsiento());

        //ACT

        ReservaResponseDto actual = service.agregarReserva(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void cancelarResrva(){

    }

    @Test
    void editarReservaOkTest(){

        //ARRANGE

        ReservaRequestConIdDto argumentSut = newReservaRequestConIdDto();
        ReservaResponseDto expected = newReservaResponseDto();

        when(repository.findById(anyLong())).thenReturn(newOptionalReserva());
        when(repository.save(any())).thenReturn(newReserva());
        when(clienteRepository.findById(anyLong())).thenReturn(newOptionalCliente());
        when(asientoRepository.findById(anyLong())).thenReturn(newOptionalAsiento());

        //ACT

        ReservaResponseDto actual = service.editarReserva(argumentSut);

        //ASSERTS

        assertEquals(expected,actual);

    }

    @Test
    void borrarReservaOkTest(){

        //ARRANGE

        MensajeResponseDto expected = new MensajeResponseDto("borrado exitoso");
        when(repository.findById(anyLong())).thenReturn(newOptionalReserva());

        //ACT

        MensajeResponseDto actual = service.borrarReserva(1L);

        //ASSERTS

        assertEquals(expected,actual);

    }

}
