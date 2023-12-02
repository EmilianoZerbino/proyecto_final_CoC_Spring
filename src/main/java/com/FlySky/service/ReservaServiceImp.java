package com.FlySky.service;

import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.ReservaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.entity.Reserva;
import com.FlySky.repository.IReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImp implements IReservaService{

    IReservaRepository repository;
    ModelMapper mapper;

    public ReservaServiceImp(IReservaRepository repository){
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<ReservaResponseDto> obtenerReservas() {
        List<Reserva> responseEntity = repository.findAll();
        List<ReservaResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, ReservaResponseDto.class)));
        return response;
    }

    @Override
    public ReservaResponseDto obtenerReservaById(long id) {
        Optional <Reserva> reserva = repository.findById(id);
        return mapper.map(reserva, ReservaResponseDto.class);
    }

    @Override
    public ReservaResponseDto agregarReserva(ReservaRequestDto reservaRequestDto) {
        Reserva reserva = mapper.map(reservaRequestDto,Reserva.class);
        Reserva persistReserva = repository.save(reserva);
        return mapper.map(persistReserva, ReservaResponseDto.class);
    }

    @Override
    public ReservaResponseDto editarReserva(ReservaRequestConIdDto reservaRequestConIdDto) {
        Reserva reserva = mapper.map(reservaRequestConIdDto,Reserva.class);
        Reserva persistReserva = repository.save(reserva);
        return mapper.map(persistReserva, ReservaResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarReserva(long id) {
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}