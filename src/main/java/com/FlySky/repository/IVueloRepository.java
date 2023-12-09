package com.FlySky.repository;

import com.FlySky.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVueloRepository extends JpaRepository<Vuelo,Long> {

    Vuelo findByNumeroVueloAndAerolinea_Id(String numeroVuelo, Long id);
}
