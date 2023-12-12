package com.FlySky.util;

import com.FlySky.dto.request.*;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.VueloSinAsientoResponseDto;

import static com.FlySky.util.FactoryOfDtos.newVueloSinAsientoResponseDto;

public class FactoryOfIntegrationDto {

//Aerolinea---------------------------------------------------------------------------------------

    public static AerolineaRequestDto newIntegrationAerolineaRequestDto(){
        return new AerolineaRequestDto("Avianca Airlines");
    }

    public static AerolineaSinVueloResponseDto newIntegrationAerolineaSinVueloResponseDto(){
        return new AerolineaSinVueloResponseDto(6L,"Avianca Airlines");
    }

    public static AerolineaRequestConIdDto newIntegrationAerolineaRequestConIdDto(){
        return new AerolineaRequestConIdDto(1L,"Avianca Airlines");
    }

    public static AerolineaSinVueloResponseDto editIntegrationAerolineaSinVueloResponseDto(){
        return new AerolineaSinVueloResponseDto(1L,"Avianca Airlines");
    }





//------------------------------------------------------------------------------------------------

//Vuelo-------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------

//Asiento-----------------------------------------------------------------------------------------

    public static AsientoRequestDto newIntegrationAsientoRequestDto(){
        return new AsientoRequestDto((short) 10,"Comun",true,  123.0,true,new IdDto(1L));
    }

    public static AsientoResponseDto newIntegrationAsientoResponseDto() {
        return new AsientoResponseDto(6L, (short) 10,"Comun",true,  123.0,true,new VueloSinAsientoResponseDto(1L,null,null,null,null,null,null,null),null);
    }

    public static AsientoRequestConIdDto newIntegrationAsientoRequestConIdDto(){
        return new AsientoRequestConIdDto(1L,(short) 10,"Comun",true,  123.0,true,new IdDto(1L));
    }

    public static AsientoResponseDto editIntegrationAsientoResponseDto() {
        return new AsientoResponseDto(1L, (short) 10,"Comun",true,  123.0,true,newVueloSinAsientoResponseDto(),null);
    }


//------------------------------------------------------------------------------------------------

//Reserva-----------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------

//Cliente-----------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------

}
