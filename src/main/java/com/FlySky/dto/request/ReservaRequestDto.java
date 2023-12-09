package com.FlySky.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaRequestDto {

    @PastOrPresent(message = "La fecha de venta debe ser igual o anterior al dia de hoy.")
    //Como validar que la fecha sea formato correcto???
    private LocalDate fechaVenta;

    @NotNull(message = "El campo formaPago no debe ser nulo")
    @NotEmpty(message = "El campo formaPago no puede quedar vacio.")
    @Size(min=3, max=50, message = "La formaPago debe contener entre 3 y 50 caracteres.")
    private String formaPago;

    @NotNull(message = "El campo Asiento { Id } no puede ser nulo")
    private IdDto asiento;

    @NotNull(message = "El campo Cliente { Id } no puede ser nulo")
    private IdDto cliente;


}
