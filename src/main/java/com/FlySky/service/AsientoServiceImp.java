package com.FlySky.service;

import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Asiento;
import com.FlySky.repository.IAsientoRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<AsientoResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(responseEntity, AsientoResponseDto.class)));
        return response;
    }

    @Override
    public AsientoResponseDto obtenerAsientoById(long id) {
        Optional <Asiento> asiento = repository.findById(id);
        return mapper.map(asiento, AsientoResponseDto.class);
    }

    @Override
    public AsientoResponseDto agregarAsiento(AsientoRequestDto asientoRequestDto) {
        Asiento asiento = mapper.map(asientoRequestDto,Asiento.class);
        Asiento persistAsiento = repository.save(asiento);
        return mapper.map(persistAsiento, AsientoResponseDto.class);
    }

    @Override
    public AsientoResponseDto editAsiento(AsientoRequestConIdDto asientoRequestConIdDto) {
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

