package com.FlySky.service;

import com.FlySky.dto.request.ClienteRequestConIdDto;
import com.FlySky.dto.request.ClienteRequestDto;
import com.FlySky.dto.response.ClienteResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Cliente;
import com.FlySky.repository.IClienteRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteServiceImp implements IClienteService{

    IClienteRepository repository;
    ModelMapper mapper;

    public ClienteServiceImp(IClienteRepository repository){
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<ClienteResponseDto> obtenerClientes() {
        List<Cliente> responseEntity = repository.findAll();
        List<ClienteResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(responseEntity, ClienteResponseDto.class)));
        return response;
    }

    @Override
    public ClienteResponseDto obtenerClienteById(long id) {
        Optional <Cliente> cliente = repository.findById(id);
        return mapper.map(cliente, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto agregarCliente(ClienteRequestDto clienteRequestDto) {
        Cliente cliente = mapper.map(clienteRequestDto,Cliente.class);
        Cliente persistCliente = repository.save(cliente);
        return mapper.map(persistCliente, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto editCliente(ClienteRequestConIdDto clienteRequestConIdDto) {
        Cliente cliente = mapper.map(clienteRequestConIdDto,Cliente.class);
        Cliente persistCliente = repository.save(cliente);
        return mapper.map(persistCliente, ClienteResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarCliente(long id) {
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}
