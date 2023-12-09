package com.FlySky.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloSinAsientoResponseDto {

    private Long id;

    private String numeroVuelo;

    private String lugarPartida;
    private String lugarLlegada;

    private LocalDateTime horarioPartida;
    private LocalDateTime horarioLlegada;

    private Integer conexion;

    private AerolineaSinVueloResponseDto aerolinea;
}