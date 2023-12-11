package com.FlySky.util;

import com.FlySky.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public static Aerolinea newAerolinea(){
        return new Aerolinea(1L,"Aerolineas Argentinas",null);
    }

    public static Optional<Aerolinea> newOptionalAerolinea(){
        return Optional.of(newAerolinea());
    }

//------------------------------------------------------------------------------------------------

//Vuelo-------------------------------------------------------------------------------------------

    public static List<Vuelo> listOfVuelosEntity(){

        List<Vuelo> response = new ArrayList<>();

        response.add(new Vuelo(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolinea(),listOfAsientosEntity()));
        response.add(new Vuelo(2L,"ARG002","Aeroparque","Bariloche",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),3,newAerolinea(),listOfAsientosEntity()));
        response.add(new Vuelo(3L,"ARG003","Aeroparque","Mendoza",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),null,newAerolinea(),listOfAsientosEntity()));
        response.add(new Vuelo(4L,"ARG004","Ezeiza","Santiago de Chile",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),5,newAerolinea(),listOfAsientosEntity()));
        response.add(new Vuelo(5L,"ARG005","Ezeiza","Mexico DF",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),null,newAerolinea(),listOfAsientosEntity()));

        return response;
    }

    public static Vuelo newVuelo(){
        return new Vuelo(1L,"ARG001","Aeroparque","Cordoba",  LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)), LocalDateTime.of(LocalDate.of(2025,12,12), LocalTime.of(12,0)),1,newAerolinea(),listOfAsientosEntity());
    }

    public static Optional<Vuelo> newOptionalVuelo(){
        return Optional.of(newVuelo());
    }

//------------------------------------------------------------------------------------------------

//Asiento-----------------------------------------------------------------------------------------

    public static List<Asiento> listOfAsientosEntity(){

        List<Asiento> response = new ArrayList<>();

        response.add(new Asiento(1L,(short)1,"Comun",true,  123.0,true,new Vuelo(),null));
        response.add(new Asiento(2L,(short)2,"Comun",true,  123.0,true,new Vuelo(),null));
        response.add(new Asiento(3L,(short)3,"Comun",true,  123.0,true,new Vuelo(),null));
        response.add(new Asiento(4L,(short)4,"Comun",true,  123.0,true,new Vuelo(),null));
        response.add(new Asiento(5L,(short)5,"Comun",true,  123.0,true,new Vuelo(),null));

        return response;
    }

    public static Asiento newAsiento(){
        return new Asiento(1L,(short)1,"Comun",true,  123.0,true,newVuelo(),null);
    }

    public static Optional<Asiento> newOptionalAsiento(){
        return Optional.of(newAsiento());
    }

//------------------------------------------------------------------------------------------------

//Reserva-----------------------------------------------------------------------------------------

    public static List<Reserva> listOfReservasEntity(){
        List<Reserva> response = new ArrayList<>();

        response.add(new Reserva(1L,LocalDate.of(2025,12,12),"efectivo","Espera",newAsiento(),newCliente()));
        response.add(new Reserva(2L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));
        response.add(new Reserva(3L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));
        response.add(new Reserva(4L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));
        response.add(new Reserva(5L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null));

        return response;
    }

    public static Reserva newReserva(){
        return new Reserva(1L,LocalDate.of(2025,12,12),"efectivo","Espera",null,null);
    }

    public static Optional<Reserva> newOptionalReserva(){
        return Optional.of(newReserva());
    }
//------------------------------------------------------------------------------------------------

//Cliente-----------------------------------------------------------------------------------------

    public static List<Cliente> listOfClientesEntity(){
        List<Cliente> response = new ArrayList<>();
        response.add(new Cliente(1L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new Cliente(2L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new Cliente(3L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new Cliente(4L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        response.add(new Cliente(5L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null));
        return response;
    }

    public static Cliente newCliente(){
        return new Cliente(1L,"Juan","Suarez","12345678",LocalDate.of(1990,12,12),"Av. Libertador 123","111541234567","juanDusrez@gmail.com",null);
    }

    public static Optional<Cliente> newOptionalCliente(){
        return Optional.of(newCliente());
    }

//------------------------------------------------------------------------------------------------
}
