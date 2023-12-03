package com.FlySky.dto.request;

import com.FlySky.entity.Asiento;
import com.FlySky.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaRequestConIdDto {

    private Long idReserva;

    private LocalDate fechaVenta;

    private String formaPago;

    private AsientoRequestDto asiento;

    private ClienteRequestDto cliente;

}
