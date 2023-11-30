package com.FlySky.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asiento {

    @Id
    private Long idAsiento;

    private Long numeroAsiento;
    private String categoria;
    private Boolean esVentanilla;
    private Double precio;
    private Boolean estaDisponible;

    @ManyToOne //COMPLETAR
    private Vuelo vuelo;

    @OneToOne //COMPLETAR
    private Reserva reserva;

}
