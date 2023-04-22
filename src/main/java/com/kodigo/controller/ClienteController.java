package com.kodigo.controller;

import com.kodigo.model.Cliente;
import com.kodigo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() throws Exception {
        List<Cliente> lista = service.listar();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Cliente obj = service.listarPorId(id);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    /*@PostMapping
    public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente) throws Exception {
        Cliente obj = service.registrarCliente(cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.CREATED);
    }*/

    //hateos - nivel 2 Richardson
    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Cliente cliente) throws Exception {
        Cliente obj = service.registrarCliente(cliente);

        // generar un bloque de localicacion del recurso creado - Richardson Maturity Model, nivel 2
        // https://martinfowler.com/articles/richardsonMaturityModel.html
        // ej: Location : localhos:9090/clientes/idCliente
        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();

        return ResponseEntity.created(localtion).build();
    }

    @PutMapping
    public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente) throws Exception {
        Cliente obj = service.modificar(cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
