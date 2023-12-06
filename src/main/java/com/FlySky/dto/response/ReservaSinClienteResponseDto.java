package com.FlySky.dto.response;

import com.FlySky.entity.Asiento;
import com.FlySky.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaSinClienteResponseDto {

    private Long idReserva;

    private LocalDate fechaVenta;

    private String formaPago;

    private String estado; // Espera - Cumplida - Incumplida - Cancelada

    private AsientoSinReservaResponseDto asiento;

}