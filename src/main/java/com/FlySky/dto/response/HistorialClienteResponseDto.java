package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistorialClienteResponseDto {

    ClienteSinReservaResponseDto cliente;

    List<ReservaSinClienteResponseDto> reservas;

    Short reservasTotales;

    //Cantidad de viajes a cada destino
    HashMap<String,Short> destinosPreferenciales;

}
