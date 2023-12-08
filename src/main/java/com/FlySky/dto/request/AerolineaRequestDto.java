package com.FlySky.dto.request;

import com.FlySky.entity.Vuelo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaRequestDto {

    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotEmpty(message = "El campo nombre no puede quedar vacio.")
    @Size(min=3, max=50, message = "El nombre debe contener entre 3 y 50 caracteres.")
    private String nombre;

    private List<VueloRequestDto> vuelos;

}
