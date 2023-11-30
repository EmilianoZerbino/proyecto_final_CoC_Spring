package com.FlySky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {

    @Id
    private Long idVuelo;

    private Long numeroVuelo;

    private String lugarPartida;
    private String lugarLlegada;

    private LocalDateTime horarioPartida;
    private LocalDateTime horarioLlegada;

    @ManyToOne //COMPLETAR
    private Aerolinea aerolinea;

    @OneToMany //COMPLETAR
    private List<Asiento> asientos;

    @ManyToMany //COMPLETAR
    private List<Vuelo> conexiones;

}
