package com.FlySky.dto.request;

import com.FlySky.entity.Asiento;
import com.FlySky.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaRequestDto {

    private String formaPago;

    private AsientoRequestDto asiento;

    private ClienteRequestDto cliente;

}
