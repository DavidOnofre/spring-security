package com.kodigo.service;
import com.kodigo.model.dto.ReporteDTO;
import com.kodigo.model.dto.CriteriosReporteDTO;

public interface IReporteService {
    ReporteDTO generarReporte(CriteriosReporteDTO criterios);
}
