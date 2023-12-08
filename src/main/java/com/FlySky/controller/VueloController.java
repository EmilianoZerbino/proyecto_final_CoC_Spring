package com.FlySky.controller;

import com.FlySky.dto.request.VueloRequestConIdDto;
import com.FlySky.dto.request.VueloRequestDto;
import com.FlySky.dto.response.VueloResponseDto;
import com.FlySky.dto.response.VueloSinAerolineaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.VueloServiceImp;
import com.FlySky.service.IVueloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vuelos")
public class VueloController {

    //--Inyeccion del Servicio (Inyeccion de Dependencia)----
    IVueloService service;

    public VueloController(VueloServiceImp service){
        this.service=service;
    }
    //--------------------------------------------------------

    //--EndPoints---------------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<VueloResponseDto>> obtenerVuelos(){
        return new ResponseEntity<>(service.obtenerVuelos(), HttpStatus.OK);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<VueloResponseDto>> obtenerVuelosConAsientosDisponibles(){
        return new ResponseEntity<>(service.obtenerVuelosConAsientosDisponibles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloResponseDto> obtenerVueloById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerVueloById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<VueloResponseDto> agregarVuelo(@RequestBody @Valid VueloRequestDto vueloRequestDto){
        return new ResponseEntity<>(service.agregarVuelo(vueloRequestDto),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<VueloResponseDto> editarVuelo(@RequestBody @Valid VueloRequestConIdDto vueloRequestConIdDto){
        return new ResponseEntity<>(service.editarVuelo(vueloRequestConIdDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> borrarVuelo(@PathVariable long id){
        return new ResponseEntity<>(service.borrarVuelo(id),HttpStatus.OK);
    }

    //--------------------------------------------------------------------------

}
