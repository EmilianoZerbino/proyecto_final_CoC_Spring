package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaSinVuelosResponseDto {

    private Long idAerolinea;

    private String nombre;

}