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
@Table(name="aerolineas")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAerolinea;

    private String nombre;

    @OneToMany(mappedBy = "aerolinea", cascade = CascadeType.ALL)
    private List<Vuelo> vuelos;
}
