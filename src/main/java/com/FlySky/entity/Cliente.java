package com.FlySky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private Long idCliente;

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;

    @OneToMany //COMPLETAR
    private List<Reserva> reservas;

}
