package com.FlySky.util;

import com.FlySky.dto.request.*;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.VueloResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FactoryOfObjects {


//Aerolinea---------------------------------------------------------------------------------------

    public static List<AerolineaResponseDto> listOfAerolineas(){
        List<AerolineaResponseDto> response = new ArrayList<>();

        response.add(new AerolineaResponseDto(1L,"Aerolineas Argentinas",null));
        response.add(new AerolineaResponseDto(2L,"Iberia Airlines",null));
        response.add(new AerolineaResponseDto(3L,"FlyBondi",null));
        response.add(new AerolineaResponseDto(4L,"Latam Airlines",null));
        response.add(new AerolineaResponseDto(5L,"Jetsmart",null));

        return response;
    }

    public static List<AerolineaSinVueloResponseDto> listOfAerolineasSinVuelo(){
        List<AerolineaSinVueloResponseDto> response = new ArrayList<>();

        response.add(new AerolineaSinVueloResponseDto(1L,"Aerolineas Argentinas"));
        response.add(new AerolineaSinVueloResponseDto(2L,"Iberia Airlines"));
        response.add(new AerolineaSinVueloResponseDto(3L,"FlyBondi"));
        response.add(new AerolineaSinVueloResponseDto(4L,"Latam Airlines"));
        response.add(new AerolineaSinVueloResponseDto(5L,"Jetsmart"));

        return response;
    }

    public static AerolineaRequestDto newAerolineaRequestDto(){
        return new AerolineaRequestDto("Aerolineas Argentinas");
    }

    public static AerolineaRequestConIdDto newAerolineaRequestConIdDto(){
        return new AerolineaRequestConIdDto(1L,"Aerolineas Argentinas");
    }

    public static AerolineaResponseDto newAerolineaResponseDto(){
        return new AerolineaResponseDto(1L,"Aerolineas Argentinas",null);
    }

    public static AerolineaSinVueloResponseDto newAerolineaSinVueloResponseDto(){
        return new AerolineaSinVueloResponseDto(1L,"Aerolineas Argentinas");
    }

//-------------------------------------------------------------------------------------------------

//Vuelo--------------------------------------------------------------------------------------------

    public static List<VueloResponseDto> listOfVuelos(){
        List<VueloResponseDto> response = new ArrayList<>();

        response.add(new VueloResponseDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolineaSinVueloResponseDto(),null));
        response.add(new VueloResponseDto(2L,"ARG002","Aeroparque","Bariloche",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),3,newAerolineaSinVueloResponseDto(),null));
        response.add(new VueloResponseDto(3L,"ARG003","Aeroparque","Mendoza",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),null,newAerolineaSinVueloResponseDto(),null));
        response.add(new VueloResponseDto(4L,"ARG004","Ezeiza","Santiago de Chile",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),5,newAerolineaSinVueloResponseDto(),null));
        response.add(new VueloResponseDto(5L,"ARG005","Ezeiza","Mexico DF",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),null,newAerolineaSinVueloResponseDto(),null));
        return response;
    }

    public static VueloRequestDto newVueloRequestDto(){
        return new VueloRequestDto("ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,new IdDto(1L),null);
    }

    public static VueloRequestConIdDto newVueloRequestConIdDto(){
        return new VueloRequestConIdDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,new IdDto(1L),null);
    }

    public static VueloResponseDto newVueloResponseDto(){
        return new VueloResponseDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolineaSinVueloResponseDto(),null);
    }

//-------------------------------------------------------------------------------------------------

//Asiento------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------

//Reserva------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------

//Cliente------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------
}
