package com.kodigo.controller;

import com.kodigo.model.Persona;
import com.kodigo.service.IPersonaService;
import com.kodigo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constantes.PERSONAS)
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar() throws Exception {
        List<Persona> lista = service.listar();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Persona obj = service.listarPorId(id);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona) throws Exception {
        Persona obj = service.registrar(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona) throws Exception {
        Persona obj = service.modificar(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
