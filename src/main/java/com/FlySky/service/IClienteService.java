package com.FlySky.service;

import com.FlySky.dto.request.ClienteRequestConIdDto;
import com.FlySky.dto.request.ClienteRequestDto;
import com.FlySky.dto.response.ClienteResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;

import java.util.List;

public interface IClienteService {

    List<ClienteResponseDto> obtenerClientes();
    ClienteResponseDto obtenerClienteById(long id);
    ClienteResponseDto agregarCliente(ClienteRequestDto clienteRequestDto);
    ClienteResponseDto editCliente(ClienteRequestConIdDto clienteRequestWithIdDto);
    MensajeResponseDto borrarCliente(long id);

}
