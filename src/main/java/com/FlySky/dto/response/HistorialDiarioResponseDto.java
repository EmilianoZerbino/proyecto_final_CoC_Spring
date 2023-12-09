package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistorialDiarioResponseDto {

    private LocalDate fecha;

    private Short cantidadReservas;

    private Double recaudación;

    private //Cantidad de viajes a cada destino
    HashMap<String,Short> destinosPopulares;
}
