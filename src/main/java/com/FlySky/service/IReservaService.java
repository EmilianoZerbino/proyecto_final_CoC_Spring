package com.FlySky.service;

import com.FlySky.dto.request.AbordarVueloRequestDto;
import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.HistorialClienteResponseDto;
import com.FlySky.dto.response.HistorialDiarioResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.dto.response.ReservaResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {

    List<ReservaResponseDto> obtenerReservas();
    ReservaResponseDto obtenerReservaById(long id);
    HistorialClienteResponseDto obtenerReservaByCliente(long id);
    HistorialDiarioResponseDto obtenerResumenDiario(LocalDate date);
    ReservaResponseDto agregarReserva(ReservaRequestDto reservaRequestDto);
    ReservaResponseDto editarReserva(ReservaRequestConIdDto reservaRequestWithIdDto);
    MensajeResponseDto cancelarReserva(long id);
    MensajeResponseDto borrarReserva(long id);
    MensajeResponseDto abordarVuelo(AbordarVueloRequestDto abordarVueloRequestDto);



}
