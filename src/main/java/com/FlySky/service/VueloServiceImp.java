package com.FlySky.service;

import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.VueloResponseDto;
import com.FlySky.dto.response.VueloSinAerolineaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Aerolinea;
import com.FlySky.entity.Asiento;
import com.FlySky.entity.Vuelo;
import com.FlySky.repository.IVueloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImp implements IVueloService{

    IVueloRepository repository;
    ModelMapper mapper;

    public VueloServiceImp(IVueloRepository repository){
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<VueloResponseDto> obtenerVuelos() {
        List<Vuelo> responseEntity = repository.findAll();
        List<VueloResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, VueloResponseDto.class)));
        return response;
    }

    @Override
    public VueloResponseDto obtenerVueloById(long id) {
        Optional <Vuelo> vuelo = repository.findById(id);
        return mapper.map(vuelo, VueloResponseDto.class);
    }

    @Override
    public VueloResponseDto agregarVuelo(VueloRequestDto vueloRequestDto) {
        Vuelo vuelo = mapper.map(vueloRequestDto,Vuelo.class);
        Vuelo persistVuelo = repository.save(vuelo);
        return mapper.map(persistVuelo, VueloResponseDto.class);
    }

    @Override
    public VueloResponseDto editarVuelo(VueloRequestConIdDto vueloRequestConIdDto) {
        Vuelo vuelo = mapper.map(vueloRequestConIdDto,Vuelo.class);
        for (Asiento asiento : vuelo.getAsientos()) {
            asiento.setVuelo(vuelo);
        }
        Vuelo persistVuelo = repository.save(vuelo);
        return mapper.map(persistVuelo, VueloResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarVuelo(long id) {
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}