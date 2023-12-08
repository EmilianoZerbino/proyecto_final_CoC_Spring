package com.FlySky.dto.request;

import com.FlySky.entity.Aerolinea;
import com.FlySky.entity.Asiento;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloRequestConIdDto {

    @NotNull(message = "El campo Id no debe ser nulo")
    @NotEmpty(message = "El campo Id no puede quedar vacio.")
    private Long idVuelo;

    @NotNull(message = "El campo Numero de Vuelo no debe ser nulo")
    private Long numeroVuelo;

    @NotNull(message = "El campo Lugar de Partida no debe ser nulo")
    @NotEmpty(message = "El campo Lugar de Partida no puede quedar vacio.")
    @Size(min=3, max=50, message = "El Lugar de Partida debe contener entre 3 y 50 caracteres.")
    private String lugarPartida;

    @NotNull(message = "El campo Lugar de Llegada no debe ser nulo")
    @NotEmpty(message = "El campo Lugar de Llegada no puede quedar vacio.")
    @Size(min=3, max=50, message = "El Lugar de Llegada debe contener entre 3 y 50 caracteres.")
    private String lugarLlegada;

    @Future(message = "La fecha y hora de partida debe ser posterior a la hora actual.")
    private LocalDateTime horarioPartida;

    @Future(message = "La fecha y hora de llegada debe ser posterior a la hora actual.")
    private LocalDateTime horarioLlegada;

    private Integer conexion;

    private AerolineaRequestConIdDto aerolinea;

    private List<AsientoRequestDto> asientos;
}
