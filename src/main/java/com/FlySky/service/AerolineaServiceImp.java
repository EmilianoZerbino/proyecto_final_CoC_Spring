package com.FlySky.service;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Aerolinea;
import com.FlySky.repository.IAerolineaRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AerolineaServiceImp implements IAerolineaService{

    IAerolineaRepository repository;
    ModelMapper mapper;

    public AerolineaServiceImp(IAerolineaRepository repository){
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<AerolineaResponseDto> obtenerAerolineas() {
        List<Aerolinea> responseEntity = repository.findAll();
        List<AerolineaResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(responseEntity, AerolineaResponseDto.class)));
        return response;
    }

    @Override
    public AerolineaResponseDto obtenerAerolineaById(long id) {
        Optional <Aerolinea> aerolinea = repository.findById(id);
        return mapper.map(aerolinea, AerolineaResponseDto.class);
    }

    @Override
    public AerolineaResponseDto agregarAerolinea(AerolineaRequestDto aerolineaRequestDto) {
        Aerolinea aerolinea = mapper.map(aerolineaRequestDto,Aerolinea.class);
        Aerolinea persistAerolinea = repository.save(aerolinea);
        return mapper.map(persistAerolinea, AerolineaResponseDto.class);
    }

    @Override
    public AerolineaResponseDto editAerolinea(AerolineaRequestConIdDto aerolineaRequestConIdDto) {
        Aerolinea aerolinea = mapper.map(aerolineaRequestConIdDto,Aerolinea.class);
        Aerolinea persistAerolinea = repository.save(aerolinea);
        return mapper.map(persistAerolinea, AerolineaResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarAerolinea(long id) {
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}
