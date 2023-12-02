package com.FlySky.service;

import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.VueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;

import java.util.List;

public interface IVueloService {

    List<VueloResponseDto> obtenerVuelos();
    VueloResponseDto obtenerVueloById(long id);
    VueloResponseDto agregarVuelo(VueloRequestDto vueloRequestDto);
    VueloResponseDto editarVuelo(VueloRequestConIdDto vueloRequestWithIdDto);
    MensajeResponseDto borrarVuelo(long id);

}
