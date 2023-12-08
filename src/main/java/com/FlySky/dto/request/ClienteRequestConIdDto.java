package com.FlySky.dto.request;

import com.FlySky.entity.Reserva;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteRequestConIdDto {

    @NotNull(message = "El campo Id no debe ser nulo")
    @NotEmpty(message = "El campo Id no puede quedar vacio.")
    private Long idCliente;

    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotEmpty(message = "El campo nombre no puede quedar vacio.")
    @Size(min=3, max=24, message = "El nombre debe contener entre 3 y 24 caracteres.")
    private String nombre;

    @NotNull(message = "El campo apellido no debe ser nulo")
    @NotEmpty(message = "El campo apellido no puede quedar vacio.")
    @Size(min=3, max=24, message = "El apellido debe contener entre 3 y 24 caracteres.")
    private String apellido;

    @NotNull(message = "El campo DNI no debe ser nulo")
    @Min(value=5000000,message = "Debe ingresar un valor mayor a $5000000")
    @Max(value=99999999,message = "Debe ingresar un valor menor a $99999999")
    private String dni;

    @PastOrPresent(message = "La fecha de nacimiento debe ser igual o anterior al dia de hoy.")
    //Como valido que la cadena enviada no sea invalida???
    private LocalDate fechNac;

    @NotNull(message = "El campo dirección no debe ser nulo")
    @NotEmpty(message = "El campo dirección no puede quedar vacio.")
    @Size(min=5, max=50, message = "La dirección debe contener entre 5 y 50 caracteres.")
    private String direccion;

    private String telefono;

    @NotNull(message = "El campo email no debe ser nulo")
    @Email(message = "El e-mail ingresado no es valido.")
    private String email;

    private List<ReservaRequestDto> reservas;
}
