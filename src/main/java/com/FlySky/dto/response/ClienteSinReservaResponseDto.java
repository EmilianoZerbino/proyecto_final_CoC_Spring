package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteSinReservaResponseDto {

    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechNac;
    private String direccion;
    private String telefono;
    private String email;

}