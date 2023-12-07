package com.FlySky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsiento;

    private Long numeroAsiento;
    private String categoria;
    private Boolean esVentanilla;
    private Double precio;
    private Boolean estaDisponible;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vuelo_id", nullable = false)
    private Vuelo vuelo;

    @OneToOne(mappedBy = "asiento",cascade = CascadeType.PERSIST)
    private Reserva reserva;

}
