package com.FlySky.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloResponseDto {

    private Long id;

    private String numeroVuelo;

    private String lugarPartida;
    private String lugarLlegada;

    private LocalDateTime horarioPartida;
    private LocalDateTime horarioLlegada;

    private Integer conexion;

    private AerolineaSinVueloResponseDto aerolinea;

    private List<AsientoSinVueloResponseDto> asientos;
}
