package com.kodigo.controller;

import com.kodigo.model.Cuenta;
import com.kodigo.service.ICuentaService;
import com.kodigo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constantes.CUENTAS)
public class CuentaController {

    @Autowired
    private ICuentaService service;

    @GetMapping
    public ResponseEntity<List<Cuenta>> listar() throws Exception {
        List<Cuenta> lista = service.listar();
        return new ResponseEntity<List<Cuenta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Cuenta obj = service.listarPorId(id);
        return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cuenta> registrar(@Valid @RequestBody Cuenta cuenta) throws Exception {
        Cuenta obj = service.registrarCuenta(cuenta);
        return new ResponseEntity<Cuenta>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cuenta> modificar(@Valid @RequestBody Cuenta cuenta) throws Exception {
        Cuenta obj = service.modificar(cuenta);
        return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
