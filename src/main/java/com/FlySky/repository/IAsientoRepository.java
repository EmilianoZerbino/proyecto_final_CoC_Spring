package com.FlySky.repository;

import com.FlySky.entity.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsientoRepository  extends JpaRepository<Asiento,Long> {
}
