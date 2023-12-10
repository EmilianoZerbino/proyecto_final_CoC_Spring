package com.FlySky.util;

import com.FlySky.entity.Aerolinea;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FactoryOfEntities {

//Aerolinea---------------------------------------------------------------------------------------

    public static List<Aerolinea> listOfAerolineasEntity(){

        List<Aerolinea> response = new ArrayList<>();

        response.add(new Aerolinea(1L,"Aerolineas Argentinas",null));
        response.add(new Aerolinea(2L,"Iberia Airlines",null));
        response.add(new Aerolinea(3L,"FlyBondi",null));
        response.add(new Aerolinea(4L,"Latam Airlines",null));
        response.add(new Aerolinea(5L,"Jetsmart",null));

        return response;
    }

    public static Optional<Aerolinea> newOptionalAerolinea(){
        return Optional.of(new Aerolinea(1L,"Aerolineas Argentinas",null));
    }

    public static Aerolinea newAerolinea(){
        return new Aerolinea(1L,"Aerolineas Argentinas",null);
    }

//------------------------------------------------------------------------------------------------

//Vuelo-------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------

//Asiento-----------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------

//Reserva-----------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------

//Cliente-----------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------
}
