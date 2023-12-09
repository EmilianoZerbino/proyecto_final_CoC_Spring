package com.FlySky.repository;

import com.FlySky.entity.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAsientoRepository  extends JpaRepository<Asiento,Long> {

    Asiento findByNumeroAsiento(Short numeroAsiento);
    List<Asiento> findByEstaDisponible(Boolean disponibilidad);
}
