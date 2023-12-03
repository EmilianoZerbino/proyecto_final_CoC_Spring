package com.FlySky.dto.request;

import com.FlySky.entity.Aerolinea;
import com.FlySky.entity.Asiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloRequestConIdDto {

    private Long idVuelo;

    private Long numeroVuelo;

    private String lugarPartida;
    private String lugarLlegada;

    private LocalDateTime horarioPartida;
    private LocalDateTime horarioLlegada;

    private Integer conexion;

    private AerolineaRequestConIdDto aerolinea;

    private List<AsientoRequestDto> asientos;
}
