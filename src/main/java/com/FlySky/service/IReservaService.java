package com.FlySky.service;

import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.ReservaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;

import java.util.List;

public interface IReservaService {

    List<ReservaResponseDto> obtenerReservas();
    ReservaResponseDto obtenerReservaById(long id);
    ReservaResponseDto agregarReserva(ReservaRequestDto reservaRequestDto);
    ReservaResponseDto editReserva(ReservaRequestConIdDto reservaRequestWithIdDto);
    MensajeResponseDto borrarReserva(long id);

}
