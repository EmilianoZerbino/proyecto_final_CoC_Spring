package com.FlySky.util;

import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;

import java.util.ArrayList;
import java.util.List;

public class FactoryOfObjects {

    public static List<AerolineaResponseDto> listOfAerolineas(){
        List<AerolineaResponseDto> response = new ArrayList<>();

        response.add(new AerolineaResponseDto(1L,"Aerolineas Argentinas",null));
        response.add(new AerolineaResponseDto(2L,"Iberia Airlines",null));
        response.add(new AerolineaResponseDto(3L,"FlyBondi",null));
        response.add(new AerolineaResponseDto(4L,"Latam Airlines",null));
        response.add(new AerolineaResponseDto(5L,"Jetsmart",null));

        return response;
    }
    public static AerolineaRequestDto newAerolineaRequestDto(){
        return new AerolineaRequestDto("Aerolineas Argentinas");
    }

    public static AerolineaSinVueloResponseDto newAerolineaSinVueloResponseDto(){
        return new AerolineaSinVueloResponseDto(1L,"Aerolineas Argentinas");
    }
}
