package com.FlySky.service;

import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.dto.response.VueloResponseDto;

import java.util.List;

public interface IVueloService {

    List<VueloResponseDto> obtenerVuelos();
    List<VueloResponseDto> obtenerVuelosConAsientosDisponibles();
    VueloResponseDto obtenerVueloById(long id);
    VueloResponseDto obtenerVueloByNumeroDeVueloAndAerolinea_Id(String numeroVuelo, Long aerolinea_Id);
    VueloResponseDto agregarVuelo(VueloRequestDto vueloRequestDto);
    VueloResponseDto editarVuelo(VueloRequestConIdDto vueloRequestWithIdDto);
    MensajeResponseDto borrarVuelo(long id);

}
