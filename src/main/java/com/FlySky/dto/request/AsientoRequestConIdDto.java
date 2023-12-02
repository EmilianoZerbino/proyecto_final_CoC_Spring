package com.FlySky.dto.request;

import com.FlySky.entity.Reserva;
import com.FlySky.entity.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AsientoRequestConIdDto {

    private Long idAsiento;

    private Long numeroAsiento;
    private String categoria;
    private Boolean esVentanilla;
    private Double precio;
    private Boolean estaDisponible;

    private VueloRequestDto vuelo;

    private ReservaRequestDto reserva;
}
