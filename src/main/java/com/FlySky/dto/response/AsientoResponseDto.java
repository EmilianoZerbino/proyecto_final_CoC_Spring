package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AsientoResponseDto {

    private Long id;

    private Short numeroAsiento;
    private String categoria;
    private Boolean esVentanilla;
    private Double precio;
    private Boolean estaDisponible;

    private VueloSinAsientoResponseDto vuelo;

    private ReservaSinAsientoResponseDto reserva;
}
