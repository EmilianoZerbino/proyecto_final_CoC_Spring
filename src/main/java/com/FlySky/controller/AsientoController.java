package com.FlySky.controller;

import com.FlySky.dto.request.AsientoRequestConIdDto;
import com.FlySky.dto.request.AsientoRequestDto;
import com.FlySky.dto.response.AsientoResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.AsientoServiceImp;
import com.FlySky.service.IAsientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asientos")
public class AsientoController {

    //--Inyeccion del Servicio (Inyeccion de Dependencia)----
    IAsientoService service;

    public AsientoController(AsientoServiceImp service){
        this.service=service;
    }
    //--------------------------------------------------------

    //--EndPoints---------------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<AsientoResponseDto>> obtenerAsientos(){
        return new ResponseEntity<>(service.obtenerAsientos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsientoResponseDto> obtenerAsientoById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerAsientoById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AsientoResponseDto> agregarAsiento(@RequestBody @Valid AsientoRequestDto asientoRequestDto){
        return new ResponseEntity<>(service.agregarAsiento(asientoRequestDto),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<AsientoResponseDto> editarAsiento(@RequestBody @Valid AsientoRequestConIdDto asientoRequestConIdDto){
        return new ResponseEntity<>(service.editarAsiento(asientoRequestConIdDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> borrarAsiento(@PathVariable long id){
        return new ResponseEntity<>(service.borrarAsiento(id),HttpStatus.OK);
    }

    //--------------------------------------------------------------------------

}
