package com.FlySky.controller;

import com.FlySky.dto.request.AerolineaRequestConIdDto;
import com.FlySky.dto.request.AerolineaRequestDto;
import com.FlySky.dto.response.AerolineaResponseDto;
import com.FlySky.dto.response.AerolineaSinVueloResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.AerolineaServiceImp;
import com.FlySky.service.IAerolineaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aerolineas")
public class AerolineaController {

    //--Inyeccion del Servicio (Inyeccion de Dependencia)----
    IAerolineaService service;

    public AerolineaController(AerolineaServiceImp service){
        this.service=service;
    }
    //--------------------------------------------------------

    //--EndPoints---------------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<AerolineaResponseDto>> obtenerAerolineas(){
        return new ResponseEntity<>(service.obtenerAerolineas(), HttpStatus.OK);
    }

    @GetMapping("/aerolineas_sin_vuelos")
    public ResponseEntity<List<AerolineaSinVueloResponseDto>> obtenerAerolineasSinVuelos(){
        return new ResponseEntity<>(service.obtenerAerolineasSinVuelos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AerolineaResponseDto> obtenerAerolineaById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerAerolineaById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AerolineaSinVueloResponseDto> agregarAerolinea(@RequestBody @Valid AerolineaRequestDto aerolineaRequestDto){
        return new ResponseEntity<>(service.agregarAerolinea(aerolineaRequestDto),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<AerolineaSinVueloResponseDto> editarAerolinea(@RequestBody @Valid AerolineaRequestConIdDto aerolineaRequestConIdDto){
        return new ResponseEntity<>(service.editarAerolinea(aerolineaRequestConIdDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> borrarAerolinea(@PathVariable long id){
        return new ResponseEntity<>(service.borrarAerolinea(id),HttpStatus.OK);
    }

    //--------------------------------------------------------------------------

}

