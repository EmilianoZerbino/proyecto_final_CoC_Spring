package com.FlySky.service;

import com.FlySky.dto.request.AbordarVueloRequestDto;
import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.*;
import com.FlySky.entity.Asiento;
import com.FlySky.entity.Cliente;
import com.FlySky.entity.Reserva;
import com.FlySky.exception.EntityAlreadyExistException;
import com.FlySky.exception.EntityNotFoundException;
import com.FlySky.exception.InsertionDBException;
import com.FlySky.repository.IAsientoRepository;
import com.FlySky.repository.IClienteRepository;
import com.FlySky.repository.IReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImp implements IReservaService{

    IReservaRepository repository;
    IAsientoRepository asientoRepository;
    IClienteRepository clienteRepository;
    ModelMapper mapper;

    public ReservaServiceImp(IReservaRepository repository,IAsientoRepository asientoRepository,IClienteRepository clienteRepository){
        this.repository = repository;
        this.asientoRepository = asientoRepository;
        this.clienteRepository = clienteRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<ReservaResponseDto> obtenerReservas() {
        List<Reserva> responseEntity = repository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay Reservas registradas");
        }
        List<ReservaResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, ReservaResponseDto.class)));
        return response;
    }

    @Override
    public ReservaResponseDto obtenerReservaById(long id) {
        Optional <Reserva> reserva = repository.findById(id);
        if(reserva.isEmpty()){
            throw new EntityNotFoundException("No hay Reserva registrada con ese ID."); // Ataja ID no encontrados.
        }
        return mapper.map(reserva, ReservaResponseDto.class);
    }

    @Override
    public HistorialClienteResponseDto obtenerReservaByCliente(long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if(cliente.isEmpty()){
            throw new EntityNotFoundException("No hay Cliente registrado con ese Id."); // Ataja ID no encontrados.
        }
        ClienteSinReservaResponseDto clienteSinReservaResponseDto = mapper.map(cliente, ClienteSinReservaResponseDto.class);
        List<Reserva> reservas = repository.findByCliente_Id(idCliente);
        if(reservas.isEmpty()){
            throw new EntityNotFoundException("No hay Reservas registradas a nombre del cliente."); // Ataja ID no encontrados.
        }
        List<ReservaSinClienteResponseDto> listReservasDto =new ArrayList<>();
        Short reservasTotales = 0;
        HashMap<String,Short> destinosPreferenciales = new HashMap<>();
        for(Reserva reserva : reservas){
            listReservasDto.add(mapper.map(reserva,ReservaSinClienteResponseDto.class));
            if(reserva.getAsiento()!=null) {
                reservasTotales++;
                Boolean existente = false;
                for (String destino : destinosPreferenciales.keySet()) {
                    if (destino.equals(reserva.getAsiento().getVuelo().getLugarLlegada())) {
                        existente = true;
                    }
                }
                if (!existente) {
                    destinosPreferenciales.put(reserva.getAsiento().getVuelo().getLugarLlegada(), (short) 1);
                } else {
                    destinosPreferenciales.put(reserva.getAsiento().getVuelo().getLugarLlegada(), (short) (destinosPreferenciales.get(reserva.getAsiento().getVuelo().getLugarLlegada()) + 1));
                }
            }
        }

        return new HistorialClienteResponseDto(clienteSinReservaResponseDto,listReservasDto,reservasTotales,destinosPreferenciales);
    }

    @Override
    public HistorialDiarioResponseDto obtenerResumenDiario(LocalDate date) {
        List<Reserva> reservas = repository.findByFechaVenta(date);
        if(reservas.isEmpty()){
            throw new EntityNotFoundException("No hay Reservas registradas en esa fecha."); // Ataja ID no encontrados.
        }
        Short cantidad = 0;
        Double recaudacion = 0.0;
        HashMap<String, Short> destinosPopulares = new HashMap<>();
        for(Reserva reserva : reservas){
            if(reserva.getAsiento()!=null) {
                cantidad++;
                recaudacion += reserva.getAsiento().getPrecio();
                Boolean existente = false;
                for (String destino : destinosPopulares.keySet()) {
                    if (destino.equals(reserva.getAsiento().getVuelo().getLugarLlegada())) {
                        existente = true;
                    }
                }
                if (!existente) {
                    destinosPopulares.put(reserva.getAsiento().getVuelo().getLugarLlegada(), (short) 1);
                } else {
                    destinosPopulares.put(reserva.getAsiento().getVuelo().getLugarLlegada(), (short) (destinosPopulares.get(reserva.getAsiento().getVuelo().getLugarLlegada()) + 1));
                }
            }
        }
        return new HistorialDiarioResponseDto(date,cantidad,recaudacion,destinosPopulares);
    }

    @Override
    public ReservaResponseDto agregarReserva(ReservaRequestDto reservaRequestDto) {
        Reserva reserva = mapper.map(reservaRequestDto,Reserva.class);
        reserva.setAsiento(reserva.getAsiento());
        reserva.setCliente(reserva.getCliente());
        if(clienteRepository.findById(reserva.getCliente().getId()).isEmpty()){
            throw new EntityNotFoundException("No hay Cliente registrado con ese ID."); // Ataja ID de cliente no encontrados.
        }
        Optional <Asiento> optionalAsiento = asientoRepository.findById(reserva.getAsiento().getId());
        if(optionalAsiento.isEmpty()){
            throw new EntityNotFoundException("No hay Asiento registrado con ese ID."); // Ataja ID de asiento no encontrados.
        }
        if(!optionalAsiento.get().getEstaDisponible()){
            throw new EntityNotFoundException("El Asiento que intenta reservar no esta disponible"); // Ataja Asiento reservado.
        }
        if(repository.findByClienteAndAsiento(reserva.getCliente(),reserva.getAsiento())!=null){
            throw new EntityAlreadyExistException("Ya hay una Reserva hecha por este Cliente en este Asiento"); //Ataja errores de DNI duplicados.
        }
        reserva.setFechaVenta(LocalDate.now());
        reserva.setEstado("Espera");
        Reserva persistReserva = repository.save(reserva);
        Optional<Asiento> asiento = asientoRepository.findById(reserva.getAsiento().getId());
        asiento.get().setEstaDisponible(false);
        Asiento resultado = asiento.orElse(null);
        asientoRepository.save(resultado);
        if(persistReserva==null){
            throw new InsertionDBException("Error al guardar la Reserva en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        return mapper.map(persistReserva, ReservaResponseDto.class);
    }

    @Override
    public MensajeResponseDto cancelarReserva(long id){
        Optional <Reserva> optionalReserva = repository.findById(id);
        if(optionalReserva.isEmpty()){
            throw new EntityNotFoundException("No hay Reserva registrada con ese ID."); // Ataja ID no encontrados.
        }
        Reserva reserva = optionalReserva.get();
        Optional <Asiento> optionalAsiento = asientoRepository.findById(reserva.getAsiento().getId());
        Asiento asiento = optionalAsiento.get();
        asiento.setEstaDisponible(true);
        Asiento persistAsiento = asientoRepository.save(asiento);
        if(persistAsiento==null){
            throw new InsertionDBException("Error al intentar modificar disponibilidad del asiento reservado en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        reserva.setAsiento(null);
        reserva.setEstado("Cancelada");
        Reserva persistReserva = repository.save(reserva);
        if(persistReserva==null){
            throw new InsertionDBException("Error al intentar persistir la cancelación de la reserva en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        return new MensajeResponseDto("Reserva Cancelada exitosamente");
    }

    @Override
    public ReservaResponseDto editarReserva(ReservaRequestConIdDto reservaRequestConIdDto) {

        //Verifica que exista la reserva.
        Optional <Reserva> optionalReserva = repository.findById(reservaRequestConIdDto.getId());
        if(optionalReserva.isEmpty()){
            throw new EntityNotFoundException("No hay Reserva registrada con ese ID."); // Ataja ID no encontrados.
        }

        //Verifica que exista el Cliente.
        Optional <Cliente> optionalCliente = clienteRepository.findById(reservaRequestConIdDto.getCliente().getId());
        if(optionalCliente.isEmpty()){
            throw new EntityNotFoundException("No hay Cliente registrado con ese ID."); // Ataja ID de cliente no encontrados.
        }

        //Verifica que exista el Asiento.
        Optional <Asiento> optionalAsiento = asientoRepository.findById(reservaRequestConIdDto.getAsiento().getId());
        if(optionalAsiento.isEmpty()){
            throw new EntityNotFoundException("No hay Asiento registrado con ese ID."); // Ataja ID de asiento no encontrados.
        }

        //Verifica que el asiento no este ocupado por otra persona.
        if(!optionalAsiento.get().getEstaDisponible() && optionalReserva.get().getAsiento().getId()!= reservaRequestConIdDto.getAsiento().getId()){
            throw new EntityNotFoundException("El Asiento que intenta reservar no esta disponible"); // Ataja Asiento reservado.
        }


        //Verifica que esta persona no tenga ya una reserva en este asiento.
        Reserva reserva = repository.findByClienteAndAsiento(optionalCliente.get(),optionalAsiento.get());
        if(reserva!=null && reserva.getId()!=reservaRequestConIdDto.getId()){
            throw new EntityAlreadyExistException("Ya hay una Reserva hecha por este Cliente en este Asiento"); //Ataja errores de DNI duplicados.
        }

        reserva = mapper.map(reservaRequestConIdDto,Reserva.class);
        reserva.setAsiento(reserva.getAsiento());
        reserva.setCliente(reserva.getCliente());
        Reserva persistReserva = repository.save(reserva);

        if(reserva==null){
            throw new InsertionDBException("Error al guardar la Reserva en la Base de Datos"); // Ataja errores de guardado en la DB.
        }

        return mapper.map(persistReserva, ReservaResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarReserva(long id) {
        obtenerReservaById(id); // Verifica Excepcion NOTFOUND
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }

    @Override
    public MensajeResponseDto abordarVuelo(AbordarVueloRequestDto abordarVueloRequestDto) {

        //Verifica que exista un vuelo con reservas.
        List<Reserva> reservas = repository.findByAsiento_Vuelo_Id(abordarVueloRequestDto.getIdVuelo());

        if(reservas.isEmpty()){
            throw new EntityNotFoundException("No hay Reserva registradas en ese Vuelo."); // Ataja ID no encontrados.
        }
        for (Reserva reserva : reservas) {
            reserva.setEstado("Abordado");
            for (Short asientoAusente: abordarVueloRequestDto.getAsientosAusentes()) {
                if(asientoAusente.equals(reserva.getAsiento().getNumeroAsiento())){
                    reserva.setEstado("Perdido");
                }
            }

            if(repository.save(reserva)==null){
                throw new InsertionDBException("Error al modificar estado de la Reserva en la Base de Datos"); // Ataja errores de guardado en la DB.
            }
        }
        return new MensajeResponseDto("Vuelo cumplimentado exitosamente");
    }
}
