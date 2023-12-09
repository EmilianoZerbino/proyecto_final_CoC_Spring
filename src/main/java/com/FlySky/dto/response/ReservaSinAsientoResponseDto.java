package com.FlySky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaSinAsientoResponseDto {

    private Long id;

    private LocalDate fechaVenta;

    private String formaPago;

    private String estado; // Espera - Cumplida - Incumplida - Cancelada

    private ClienteSinReservaResponseDto cliente;
}