package com.FlySky.controller;

import com.FlySky.dto.request.ClienteRequestConIdDto;
import com.FlySky.dto.request.ClienteRequestDto;
import com.FlySky.dto.response.ClienteResponseDto;
import com.FlySky.dto.response.MensajeResponseDto;
import com.FlySky.service.ClienteServiceImp;
import com.FlySky.service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    //--Inyeccion del Servicio (Inyeccion de Dependencia)----
    IClienteService service;

    public ClienteController(ClienteServiceImp service){
        this.service=service;
    }
    //--------------------------------------------------------

    //--EndPoints---------------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<ClienteResponseDto>> obtenerClientes(){
        return new ResponseEntity<>(service.obtenerClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> obtenerClienteById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerClienteById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ClienteResponseDto> agregarCliente(@RequestBody @Valid ClienteRequestDto clienteRequestDto){
        return new ResponseEntity<>(service.agregarCliente(clienteRequestDto),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ClienteResponseDto> editarCliente(@RequestBody @Valid ClienteRequestConIdDto clienteRequestConIdDto){
        return new ResponseEntity<>(service.editarCliente(clienteRequestConIdDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> borrarCliente(@PathVariable long id){
        return new ResponseEntity<>(service.borrarCliente(id),HttpStatus.OK);
    }

    //--------------------------------------------------------------------------

}