package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteResponseDto {

    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechNac;
    private String direccion;
    private String telefono;
    private String email;

    private List<ReservaSinClienteResponseDto> reservas;
}
