package com.kodigo.controller;

import com.kodigo.model.Movimiento;
import com.kodigo.model.dto.ReporteDTO;
import com.kodigo.model.dto.CriteriosReporteDTO;
import com.kodigo.service.IMovimientoService;
import com.kodigo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constantes.MOVIMIENTOS)
public class MovimientoController {

    @Autowired
    private IMovimientoService service;

    @GetMapping
    public ResponseEntity<List<Movimiento>> listar() throws Exception {
        List<Movimiento> lista = service.listar();
        return new ResponseEntity<List<Movimiento>>(lista, HttpStatus.OK);
    }

    @GetMapping(Constantes.REPORTE)
    public ResponseEntity<ReporteDTO> reporteMovimientos(@RequestBody CriteriosReporteDTO criterios) throws Exception {
        ReporteDTO obj = service.generarReporte(criterios);
        return new ResponseEntity<ReporteDTO>(obj, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Movimiento obj = service.listarPorId(id);
        return new ResponseEntity<Movimiento>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movimiento> registrar(@Valid @RequestBody Movimiento movimiento) throws Exception {
        Movimiento obj = service.registrarTransaccional(movimiento);
        return new ResponseEntity<Movimiento>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Movimiento> modificar(@Valid @RequestBody Movimiento movimiento) throws Exception {
        Movimiento obj = service.modificar(movimiento);
        return new ResponseEntity<Movimiento>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
