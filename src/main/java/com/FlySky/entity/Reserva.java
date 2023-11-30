package com.FlySky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    private Long idReserva;

    private String formaPago;

    @OneToOne(mappedBy = "reserva")
    private Asiento asiento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente", nullable = false)
    private Cliente cliente;

}
