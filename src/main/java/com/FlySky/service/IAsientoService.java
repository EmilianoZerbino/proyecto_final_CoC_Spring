package com.FlySky.service;

import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;

import java.util.List;

public interface IAsientoService {

    List<AsientoResponseDto> obtenerAsientos();
    AsientoResponseDto obtenerAsientoById(long id);
    AsientoResponseDto agregarAsiento(AsientoRequestDto asientoRequestDto);
    AsientoResponseDto editarAsiento(AsientoRequestConIdDto asientoRequestWithIdDto);
    MensajeResponseDto borrarAsiento(long id);

}
