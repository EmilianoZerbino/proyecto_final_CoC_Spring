package com.FlySky.controller;

import com.FlySky.dto.request.AbordarVueloRequestDto;
import com.FlySky.dto.request.ReservaRequestConIdDto;
import com.FlySky.dto.request.ReservaRequestDto;
import com.FlySky.dto.response.HistorialClienteResponseDto;
import com.FlySky.dto.response.ReservaResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.ReservaServiceImp;
import com.FlySky.service.IReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservas")
public class ReservaController {

    //--Inyeccion del Servicio (Inyeccion de Dependencia)----
    IReservaService service;

    public ReservaController(ReservaServiceImp service){
        this.service=service;
    }
    //--------------------------------------------------------

    //--EndPoints---------------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<ReservaResponseDto>> obtenerReservas(){
        return new ResponseEntity<>(service.obtenerReservas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDto> obtenerReservaById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerReservaById(id), HttpStatus.OK);
    }

    @GetMapping("/preferencias/{idCliente}")
    public ResponseEntity<HistorialClienteResponseDto> obtenerReservaByCliente(@PathVariable long idCliente){
        return new ResponseEntity<>(service.obtenerReservaByCliente(idCliente), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ReservaResponseDto> agregarReserva(@RequestBody @Valid ReservaRequestDto reservaRequestDto){
        return new ResponseEntity<>(service.agregarReserva(reservaRequestDto),HttpStatus.OK);
    }

    @PostMapping("/abordar")
    public ResponseEntity<MensajeResponseDto> abordarVuelo(@RequestBody @Valid AbordarVueloRequestDto abordarVueloRequestDto){
        return new ResponseEntity<>(service.abordarVuelo(abordarVueloRequestDto),HttpStatus.OK);
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<MensajeResponseDto> cancelarReserva(@PathVariable long id){
        return new ResponseEntity<>(service.cancelarReserva(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ReservaResponseDto> editarReserva(@RequestBody @Valid ReservaRequestConIdDto reservaRequestConIdDto){
        return new ResponseEntity<>(service.editarReserva(reservaRequestConIdDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> borrarReserva(@PathVariable long id){
        return new ResponseEntity<>(service.borrarReserva(id),HttpStatus.OK);
    }

    //--------------------------------------------------------------------------

}
