package com.FlySky.repository;

import com.FlySky.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAerolineaRepository extends JpaRepository<Aerolinea,Long> {

    Aerolinea findByNombre(String nombre);

}
