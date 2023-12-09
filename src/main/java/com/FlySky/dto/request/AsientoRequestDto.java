package com.FlySky.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AsientoRequestDto {

    @NotNull(message = "El campo Numero de Asiento no debe ser nulo")
    private Short numeroAsiento;

    @NotNull(message = "El campo categoria no debe ser nulo")
    @NotEmpty(message = "El campo categoria no puede quedar vacio.")
    @Size(min=3, max=24, message = "La categoria debe contener entre 3 y 24 caracteres.")
    private String categoria;

    //Validar que sea un Booleano???
    private Boolean esVentanilla;

    //validar que sea un float???
    private Double precio;

    //Validar que sea un Booleano???
    private Boolean estaDisponible;

    private IdDto vuelo;

}
