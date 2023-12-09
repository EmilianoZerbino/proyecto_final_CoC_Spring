package com.FlySky.service;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Aerolinea;
import com.FlySky.exception.EntityAlreadyExistException;
import com.FlySky.exception.EntityNotFoundException;
import com.FlySky.exception.InsertionDBException;
import com.FlySky.repository.IAerolineaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AerolineaServiceImp implements IAerolineaService {

    IAerolineaRepository repository;
    ModelMapper mapper;

    public AerolineaServiceImp(IAerolineaRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<AerolineaResponseDto> obtenerAerolineas() {
        List<Aerolinea> responseEntity = repository.findAll();
        if (responseEntity.isEmpty()) {
            throw new EntityNotFoundException("No hay Aerolineas registradas");
        }
        List<AerolineaResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r -> response.add(mapper.map(r, AerolineaResponseDto.class)));
        return response;
    }

    @Override
    public List<AerolineaSinVueloResponseDto> obtenerAerolineasSinVuelos() {
        List<Aerolinea> responseEntity = repository.findAll();
        if (responseEntity.isEmpty()) {
            throw new EntityNotFoundException("No hay Aerolineas registradas");
        }
        List<AerolineaSinVueloResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r -> response.add(mapper.map(r, AerolineaSinVueloResponseDto.class)));
        return response;
    }

    @Override
    public AerolineaResponseDto obtenerAerolineaById(long id) {
        Optional<Aerolinea> aerolinea = repository.findById(id);
        if (aerolinea.isEmpty()) {
            throw new EntityNotFoundException("No hay Aerolinea registrada con ese ID."); // Ataja ID no encontrados.
        }
        return mapper.map(aerolinea, AerolineaResponseDto.class);
    }

    @Override
    public AerolineaSinVueloResponseDto agregarAerolinea(AerolineaRequestDto aerolineaRequestDto) {
        Aerolinea aerolinea = mapper.map(aerolineaRequestDto, Aerolinea.class);
        if (repository.findByNombre(aerolinea.getNombre()) != null) {
            throw new EntityAlreadyExistException("Ya se encuentra una Aerolinea registrada con ese Nombre"); //Ataja errores de DNI duplicados.
        }
        Aerolinea persistAerolinea = repository.save(aerolinea);
        if (aerolinea == null) {
            throw new InsertionDBException("Error al guardar la Aerolinea en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        return mapper.map(persistAerolinea, AerolineaSinVueloResponseDto.class);
    }

    @Override
    public AerolineaSinVueloResponseDto editarAerolinea(AerolineaRequestConIdDto aerolineaRequestConIdDto) {
        obtenerAerolineaById(aerolineaRequestConIdDto.getId()); // Verifica Excepcion NOTFOUND
        Aerolinea nuevaAerolinea = mapper.map(aerolineaRequestConIdDto, Aerolinea.class);
        Aerolinea persistAerolinea = repository.save(nuevaAerolinea);
        return mapper.map(persistAerolinea, AerolineaSinVueloResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarAerolinea(long id) {
        obtenerAerolineaById(id); // Verifica Excepcion NOTFOUND
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}
