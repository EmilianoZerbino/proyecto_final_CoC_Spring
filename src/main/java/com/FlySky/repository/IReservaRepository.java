package com.FlySky.repository;

import com.FlySky.entity.Asiento;
import com.FlySky.entity.Cliente;
import com.FlySky.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository  extends JpaRepository<Reserva,Long> {

    Reserva findByClienteAndAsiento(Cliente cliente, Asiento asiento);
}
