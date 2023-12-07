package com.FlySky.service;

import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Asiento;
import com.FlySky.exception.EntityNotFoundException;
import com.FlySky.exception.InsertionDBException;
import com.FlySky.repository.IAsientoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsientoServiceImp implements IAsientoService{

    IAsientoRepository repository;
    ModelMapper mapper;

    public AsientoServiceImp(IAsientoRepository repository){
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<AsientoResponseDto> obtenerAsientos() {
        List<Asiento> responseEntity = repository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay Asientos registrados");
        }
        List<AsientoResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, AsientoResponseDto.class)));
        return response;
    }

    @Override
    public AsientoResponseDto obtenerAsientoById(long id) {
        Optional <Asiento> asiento = repository.findById(id);
        if(asiento.isEmpty()){
            throw new EntityNotFoundException("No hay Asiento registrada con ese ID."); // Ataja ID no encontrados.
        }
        return mapper.map(asiento, AsientoResponseDto.class);
    }

    @Override
    public AsientoResponseDto agregarAsiento(AsientoRequestDto asientoRequestDto) {
        Asiento asiento = mapper.map(asientoRequestDto,Asiento.class);
        Asiento persistAsiento = repository.save(asiento);
        if(asiento==null){
            throw new InsertionDBException("Error al guardar la Asiento en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        return mapper.map(persistAsiento, AsientoResponseDto.class);
    }

    @Override
    public AsientoResponseDto editarAsiento(AsientoRequestConIdDto asientoRequestConIdDto) {
        Asiento asiento = mapper.map(asientoRequestConIdDto,Asiento.class);
        Asiento persistAsiento = repository.save(asiento);
        return mapper.map(persistAsiento, AsientoResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarAsiento(long id) {
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}

