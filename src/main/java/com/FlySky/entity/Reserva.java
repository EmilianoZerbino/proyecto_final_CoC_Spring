package com.FlySky.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    private Long idCompra;

    private String formaPago;

    @OneToOne // COMPLETAR
    private Asiento asiento;

    @OneToOne // COMPLETAR
    private Cliente cliente;

}
