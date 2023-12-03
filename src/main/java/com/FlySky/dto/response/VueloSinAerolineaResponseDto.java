package com.FlySky.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloSinAerolineaResponseDto {

    private Long idVuelo;

    private Long numeroVuelo;

    private String lugarPartida;
    private String lugarLlegada;

    private LocalDateTime horarioPartida;
    private LocalDateTime horarioLlegada;

    private Integer conexion;

    private List<AsientoResponseDto> asientos;
}
