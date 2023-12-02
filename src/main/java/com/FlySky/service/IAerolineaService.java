package com.FlySky.service;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;

import java.util.List;

public interface IAerolineaService {

    List<AerolineaResponseDto> obtenerAerolineas();
    AerolineaResponseDto obtenerAerolineaById(long id);
    AerolineaResponseDto agregarAerolinea(AerolineaRequestDto aerolineaRequestDto);
    AerolineaResponseDto editarAerolinea(AerolineaRequestConIdDto aerolineaRequestWithIdDto);
    MensajeResponseDto borrarAerolinea(long id);
    
}
