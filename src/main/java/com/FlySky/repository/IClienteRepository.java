package com.FlySky.repository;

import com.FlySky.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository  extends JpaRepository<Cliente,Long> {
}
