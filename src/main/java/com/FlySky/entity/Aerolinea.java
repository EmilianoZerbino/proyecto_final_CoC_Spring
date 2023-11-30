package com.FlySky.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aerolinea {

    @Id
    private Long idAerolinea;

    private String nombre;

    @OneToMany //COMPLETAR
    private List<Vuelo> vuelos;
}
