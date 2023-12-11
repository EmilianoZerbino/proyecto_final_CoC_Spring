package com.FlySky.util;

import com.FlySky.dto.request.*;
import com.FlySky.dto.response.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FactoryOfDtos {

//Aerolinea---------------------------------------------------------------------------------------

    public static List<AerolineaResponseDto> listOfAerolineasDto(){
        List<AerolineaResponseDto> response = new ArrayList<>();

        response.add(new AerolineaResponseDto(1L,"Aerolineas Argentinas",null));
        response.add(new AerolineaResponseDto(2L,"Iberia Airlines",null));
        response.add(new AerolineaResponseDto(3L,"FlyBondi",null));
        response.add(new AerolineaResponseDto(4L,"Latam Airlines",null));
        response.add(new AerolineaResponseDto(5L,"Jetsmart",null));

        return response;
    }

    public static List<AerolineaSinVueloResponseDto> listOfAerolineasSinVueloDto(){
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

    public static List<VueloResponseDto> listOfVuelosDto(){
        List<VueloResponseDto> response = new ArrayList<>();

        response.add(new VueloResponseDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolineaSinVueloResponseDto(),listOfAsientosSinVueloResponseDto()));
        response.add(new VueloResponseDto(2L,"ARG002","Aeroparque","Bariloche",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),3,newAerolineaSinVueloResponseDto(),listOfAsientosSinVueloResponseDto()));
        response.add(new VueloResponseDto(3L,"ARG003","Aeroparque","Mendoza",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),null,newAerolineaSinVueloResponseDto(),listOfAsientosSinVueloResponseDto()));
        response.add(new VueloResponseDto(4L,"ARG004","Ezeiza","Santiago de Chile",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),5,newAerolineaSinVueloResponseDto(),listOfAsientosSinVueloResponseDto()));
        response.add(new VueloResponseDto(5L,"ARG005","Ezeiza","Mexico DF",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),null,newAerolineaSinVueloResponseDto(),listOfAsientosSinVueloResponseDto()));
        return response;
    }

    public static VueloRequestDto newVueloRequestDto(){
        return new VueloRequestDto("ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,new IdDto(1L),listOfAsientosRequestDto());
    }

    public static VueloRequestConIdDto newVueloRequestConIdDto(){
        return new VueloRequestConIdDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,new IdDto(1L),listOfAsientosRequestConIdDto());
    }

    public static VueloResponseDto newVueloResponseDto(){
        return new VueloResponseDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolineaSinVueloResponseDto(),listOfAsientosSinVueloResponseDto());
    }

    public static VueloSinAsientoResponseDto newVueloSinAsientoResponseDto(){
        return new VueloSinAsientoResponseDto(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolineaSinVueloResponseDto());
    }

//-------------------------------------------------------------------------------------------------

//Asiento------------------------------------------------------------------------------------------

    public static List<AsientoResponseDto> listOfAsientosDto(){
        List<AsientoResponseDto> response = new ArrayList<>();

        response.add(new AsientoResponseDto(1L, (short) 1,"Comun",true,  123.0,true,new VueloSinAsientoResponseDto(),null));
        response.add(new AsientoResponseDto(2L, (short) 2,"Comun",true,  123.0,true,new VueloSinAsientoResponseDto(),null));
        response.add(new AsientoResponseDto(3L, (short) 3,"Comun",true,  123.0,true,new VueloSinAsientoResponseDto(),null));
        response.add(new AsientoResponseDto(4L, (short) 4,"Comun",true,  123.0,true,new VueloSinAsientoResponseDto(),null));
        response.add(new AsientoResponseDto(5L, (short) 5,"Comun",true,  123.0,true,new VueloSinAsientoResponseDto(),null));
        return response;
    }

    public static List<AsientoSinVueloResponseDto> listOfAsientosSinVueloResponseDto(){
        List<AsientoSinVueloResponseDto> response = new ArrayList<>();

        response.add(new AsientoSinVueloResponseDto(1L, (short) 1,"Comun",true,  123.0,true,null));
        response.add(new AsientoSinVueloResponseDto(2L, (short) 2,"Comun",true,  123.0,true,null));
        response.add(new AsientoSinVueloResponseDto(3L, (short) 3,"Comun",true,  123.0,true,null));
        response.add(new AsientoSinVueloResponseDto(4L, (short) 4,"Comun",true,  123.0,true,null));
        response.add(new AsientoSinVueloResponseDto(5L, (short) 5,"Comun",true,  123.0,true,null));
        return response;
    }

    public static List<AsientoRequestDto> listOfAsientosRequestDto(){
        List<AsientoRequestDto> response = new ArrayList<>();
        response.add(new AsientoRequestDto((short)1,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestDto((short)2,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestDto((short)3,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestDto((short)4,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestDto((short)5,"Comun",true,  123.0,true,new IdDto(1L)));
        return response;
    }

    public static List<AsientoRequestConIdDto> listOfAsientosRequestConIdDto(){
        List<AsientoRequestConIdDto> response = new ArrayList<>();
        response.add(new AsientoRequestConIdDto(1L,(short)1,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestConIdDto(2L,(short)2,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestConIdDto(3L,(short)3,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestConIdDto(4L,(short)4,"Comun",true,  123.0,true,new IdDto(1L)));
        response.add(new AsientoRequestConIdDto(5L,(short)5,"Comun",true,  123.0,true,new IdDto(1L)));
        return response;
    }

    public static AsientoRequestDto newAsientoRequestDto(){
        return new AsientoRequestDto((short) 1,"Comun",true,  123.0,true,new IdDto(1L));
    }

    public static AsientoRequestConIdDto newAsientoRequestConIdDto(){
        return new AsientoRequestConIdDto(1L,(short) 1,"Comun",true,  123.0,true,new IdDto(1L));
    }

    public static AsientoResponseDto newAsientoResponseDto(){
        return new AsientoResponseDto(1L, (short) 1,"Comun",true,  123.0,true,newVueloSinAsientoResponseDto(),null);
    }

    public static AsientoSinReservaResponseDto newAsientoSinReservaResponseDto(){
        return new AsientoSinReservaResponseDto(1L, (short) 1,"Comun",true,  123.0,true,newVueloSinAsientoResponseDto());
    }

//-------------------------------------------------------------------------------------------------

//Reserva------------------------------------------------------------------------------------------

    public static List<ReservaResponseDto> listOfReservasDto(){
        List<ReservaResponseDto> response = new ArrayList<>();

        response.add(new ReservaResponseDto(1L,LocalDate.of(2025,12,12),"efectivo","Espera",newAsientoSinReservaResponseDto(),newClienteSinReservaResponseDto()));
        response.add(new ReservaResponseDto(2L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));
        response.add(new ReservaResponseDto(3L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));
        response.add(new ReservaResponseDto(4L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));
        response.add(new ReservaResponseDto(5L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));

        return response;
    }

    public static List<ReservaSinClienteResponseDto> listOfReservasSinClienteDto(){
        List<ReservaSinClienteResponseDto> response = new ArrayList<>();

        response.add(new ReservaSinClienteResponseDto(1L,LocalDate.of(2025,12,12),"efectivo","Espera",newAsientoSinReservaResponseDto()));
        response.add(new ReservaSinClienteResponseDto(2L,LocalDate.of(2025,12,12),"efectivo","Espera",null));
        response.add(new ReservaSinClienteResponseDto(3L,LocalDate.of(2025,12,12),"efectivo","Espera",null));
        response.add(new ReservaSinClienteResponseDto(4L,LocalDate.of(2025,12,12),"efectivo","Espera",null));
        response.add(new ReservaSinClienteResponseDto(5L,LocalDate.of(2025,12,12),"efectivo","Espera",null));

        return response;
    }

    public static ReservaRequestDto newReservaRequestDto(){
        return new ReservaRequestDto(LocalDate.of(2025,12,12),"efectivo",new IdDto(1L),new IdDto(1L));
    }

    public static ReservaRequestConIdDto newReservaRequestConIdDto(){
        return new ReservaRequestConIdDto(1L, LocalDate.of(2025,12,12),"efectivo","Espera",new IdDto(1L),new IdDto(1L));
    }

    public static ReservaResponseDto newReservaResponseDto(){
        return new ReservaResponseDto(1L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null);
    }

    public static HistorialClienteResponseDto newHistorialClienteResponseDto(){
        HashMap<String,Short> destinosPreferenciales=new HashMap<>();
        destinosPreferenciales.put("Cordoba",(short)1);
        return new HistorialClienteResponseDto(newClienteSinReservaResponseDto(), listOfReservasSinClienteDto(),(short) 1,destinosPreferenciales);
    }

    public static HistorialDiarioResponseDto newHistorialDiarioResponseDto(){
        HashMap<String,Short> destinosPreferenciales=new HashMap<>();
        destinosPreferenciales.put("Cordoba",(short)1);
        return new HistorialDiarioResponseDto(LocalDate.of(2023,12,12),(short) 1, 123.0,destinosPreferenciales);
    }

    public static AbordarVueloRequestDto newAbordarVueloRequestDto(){
        return new AbordarVueloRequestDto(1L,null);
    }

//-------------------------------------------------------------------------------------------------

//Cliente------------------------------------------------------------------------------------------

    public static List<ClienteResponseDto> listOfClientesDto(){
        List<ClienteResponseDto> response = new ArrayList<>();
        response.add(new ClienteResponseDto(1L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new ClienteResponseDto(2L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new ClienteResponseDto(3L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new ClienteResponseDto(4L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new ClienteResponseDto(5L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        return response;
    }

    public static ClienteRequestDto newClienteRequestDto(){
        return new ClienteRequestDto("Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com");
    }

    public static ClienteRequestConIdDto newClienteRequestConIdDto(){
        return new ClienteRequestConIdDto(1L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null);
    }

    public static ClienteResponseDto newClienteResponseDto(){
        return new ClienteResponseDto(1L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null);
    }

    public static ClienteSinReservaResponseDto newClienteSinReservaResponseDto(){
        return new ClienteSinReservaResponseDto(1L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com");
    }

//-------------------------------------------------------------------------------------------------
}
