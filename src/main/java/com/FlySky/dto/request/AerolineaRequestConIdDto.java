package com.FlySky.dto.request;

import com.FlySky.entity.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaRequestConIdDto {

    private Long idAerolinea;

    private String nombre;

    private List<VueloRequestDto> vuelos;

}
