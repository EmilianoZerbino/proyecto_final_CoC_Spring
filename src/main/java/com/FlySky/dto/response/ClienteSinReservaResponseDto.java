package com.FlySky.dto.response;

import com.FlySky.entity.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteSinReservaResponseDto {

    private Long idCliente;

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;

}