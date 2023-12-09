package com.FlySky.service;

import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.dto.response.VueloResponseDto;
import com.FlySky.entity.Asiento;
import com.FlySky.entity.Vuelo;
import com.FlySky.exception.EntityAlreadyExistException;
import com.FlySky.exception.EntityNotFoundException;
import com.FlySky.exception.InsertionDBException;
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
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay Vuelos registrados");
        }
        List<VueloResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, VueloResponseDto.class)));
        return response;
    }

    @Override
    public List<VueloResponseDto> obtenerVuelosConAsientosDisponibles() {
        List<Vuelo> responseEntity = repository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay Vuelos registrados");
        }
        List<VueloResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(r->response.add(mapper.map(r, VueloResponseDto.class)));
        for(int i=0;i<response.size();i++){
            for(int j=0;j<response.get(i).getAsientos().size();j++){
                    if (!response.get(i).getAsientos().get(j).getEstaDisponible()){
                        response.get(i).getAsientos().remove(response.get(i).getAsientos().get(j));
                        j--;
                    }
            }
            if(response.get(i).getAsientos().isEmpty()){
                response.remove(response.get(i));
                i--;
            }
        }
        if(response.isEmpty()){
            throw new EntityNotFoundException("No hay vuelos con asientos disponibles");
        }
        return response;
    }

    @Override
    public VueloResponseDto obtenerVueloById(long id) {
        Optional <Vuelo> vuelo = repository.findById(id);
        if(vuelo.isEmpty()){
            throw new EntityNotFoundException("No hay Vuelo registrado con ese ID."); // Ataja ID no encontrados.
        }
        return mapper.map(vuelo, VueloResponseDto.class);
    }

    @Override
    public VueloResponseDto obtenerVueloByNumeroDeVueloAndAerolinea_Id(String numeroVuelo, Long aerolinea_Id) {
        Vuelo vuelo = repository.findByNumeroVueloAndAerolinea_Id(numeroVuelo, aerolinea_Id);
        if(vuelo==null){
            throw new EntityNotFoundException("No hay Vuelo registrado con ese Numero de Vuelo en esa Aerolinea."); // Ataja ID no encontrados.
        }
        return mapper.map(vuelo, VueloResponseDto.class);
    }

    @Override
    public VueloResponseDto agregarVuelo(VueloRequestDto vueloRequestDto) {
        if(repository.findByNumeroVueloAndAerolinea_Id(vueloRequestDto.getNumeroVuelo(), vueloRequestDto.getAerolinea().getId())!=null){
            throw new EntityAlreadyExistException("Ya hay un Vuelo con ese Numero de Identificación registrado en la Aerolinea"); //Ataja errores de DNI duplicados.
        }
        Vuelo vuelo = mapper.map(vueloRequestDto,Vuelo.class);
        vuelo.setAerolinea(vuelo.getAerolinea());
        for (Asiento asiento : vuelo.getAsientos()) {
            asiento.setVuelo(vuelo);
        }
        for (int j=0;j<vuelo.getAsientos().size()-1;j++) {
            for (int k=j+1;k<vuelo.getAsientos().size();k++) {
                if(vuelo.getAsientos().get(j).getNumeroAsiento().equals(vuelo.getAsientos().get(k).getNumeroAsiento())){
                    throw new EntityAlreadyExistException("Ingreso dos Asientos con el mismo Numero de Identificación. Operación Cancelada"); //Ataja errores de DNI duplicados.
                }
            }
        }
        Vuelo persistVuelo = repository.save(vuelo);
        if(vuelo==null){
            throw new InsertionDBException("Error al guardar la Vuelo en la Base de Datos"); // Ataja errores de guardado en la DB.
        }
        return mapper.map(persistVuelo, VueloResponseDto.class);
    }

    @Override
    public VueloResponseDto editarVuelo(VueloRequestConIdDto vueloRequestConIdDto) {
        obtenerVueloById(vueloRequestConIdDto.getId()); // Verifica Excepcion NOTFOUND
        Vuelo vuelo = mapper.map(vueloRequestConIdDto,Vuelo.class);
        for (Asiento asiento : vuelo.getAsientos()) {
            asiento.setVuelo(vuelo);
        }
        Vuelo persistVuelo = repository.save(vuelo);
        return mapper.map(persistVuelo, VueloResponseDto.class);
    }

    @Override
    public MensajeResponseDto borrarVuelo(long id) {
        obtenerVueloById(id); // Verifica Excepcion NOTFOUND
        repository.deleteById(id);
        return new MensajeResponseDto("borrado exitoso");
    }
}