package com.FlySky.repository;

import com.FlySky.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository  extends JpaRepository<Reserva,Long> {
}
