package com.FlySky.dto.request;

import com.FlySky.entity.Asiento;
import com.FlySky.entity.Cliente;
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
public class ReservaRequestConIdDto {

    @NotNull(message = "El campo Id no debe ser nulo")
    @NotEmpty(message = "El campo Id no puede quedar vacio.")
    private Long idReserva;

    @PastOrPresent(message = "La fecha de venta debe ser igual o anterior al dia de hoy.")
    //Como validar que la fecha sea formato correcto???
    private LocalDate fechaVenta;

    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotEmpty(message = "El campo nombre no puede quedar vacio.")
    @Size(min=3, max=50, message = "El nombre debe contener entre 3 y 50 caracteres.")
    private String formaPago;

    @NotNull(message = "El campo estado no debe ser nulo")
    @NotEmpty(message = "El campo estado no puede quedar vacio.")
    @Size(min=3, max=24, message = "El estado debe contener entre 3 y 24 caracteres.")
    private String estado;

    private AsientoRequestConIdDto asiento;

    private ClienteRequestConIdDto cliente;

}
