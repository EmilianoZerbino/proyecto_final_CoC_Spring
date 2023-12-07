package com.FlySky.service;

import com.FlySky.dto.request.ClienteRequestConIdDto;
import com.FlySky.dto.request.ClienteRequestDto;
import com.FlySky.dto.response.ClienteResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Cliente;
import com.FlySky.exception.EntityNotFoundException;
import com.FlySky.exception.InsertionDBException;
import com.FlySky.repository.IClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay Clientes Registrados");
        }
        List<ClienteResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, ClienteResponseDto.class)));
        return response;
    }

    @Override
    public ClienteResponseDto obtenerClienteById(long id) {
        Optional <Cliente> cliente = repository.findById(id);
        if(cliente.isEmpty()){
            throw new EntityNotFoundException("No hay Cliente registrada con ese ID."); // Ataja ID no encontrados.
        }
        return mapper.map(cliente, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto agregarCliente(ClienteRequestDto clienteRequestDto) {
        Cliente cliente = mapper.map(clienteRequestDto,Cliente.class);
        Cliente persistCliente = repository.save(cliente);
        if(cliente==null){
            throw new InsertionDBException("Error al guardar la Cliente en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        return mapper.map(persistCliente, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto editarCliente(ClienteRequestConIdDto clienteRequestConIdDto) {
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
