package com.kodigo.controller;

import com.kodigo.model.dto.CriteriosReporteDTO;
import com.kodigo.model.dto.ReporteDTO;
import com.kodigo.service.IReporteService;
import com.kodigo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constantes.REPORTES)
public class ReporteController {

    @Autowired
    private IReporteService service;

    @GetMapping(Constantes.REPORTE_POR_MOVIMIENTOS)
    public ResponseEntity<ReporteDTO> reporteMovimientos(@RequestBody CriteriosReporteDTO criterios) throws Exception {
        ReporteDTO obj = service.generarReporte(criterios);
        return new ResponseEntity<ReporteDTO>(obj, HttpStatus.OK);
    }

}
