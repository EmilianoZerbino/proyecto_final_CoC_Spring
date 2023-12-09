package com.FlySky.service;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Aerolinea;

import java.util.List;

public interface IAerolineaService {

    List<AerolineaResponseDto> obtenerAerolineas();
    List<AerolineaSinVueloResponseDto> obtenerAerolineasSinVuelos();
    AerolineaResponseDto obtenerAerolineaById(long id);
    AerolineaSinVueloResponseDto agregarAerolinea(AerolineaRequestDto aerolineaRequestDto);
    AerolineaSinVueloResponseDto editarAerolinea(AerolineaRequestConIdDto aerolineaRequestConIdDto);
    MensajeResponseDto borrarAerolinea(long id);
    
}
