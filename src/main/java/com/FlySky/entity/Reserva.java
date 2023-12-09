package com.FlySky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    //OME PASÓ POR AQUÍ, SOLO COMMIT DE PRUEBA (PROMETO BORRAR EL COMENTARIO XD)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaVenta;

    private String formaPago;

    private String estado; // Espera - Abordado - Perdido - Cancelado

    @OneToOne
    @JoinColumn(name = "asiento_id")
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}
