package com.FlySky.dto.response;

import com.FlySky.entity.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaResponseDto {

    private Long idAerolinea;

    private String nombre;

    private List<VueloResponseDto> vuelos;

}
