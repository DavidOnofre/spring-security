package com.kodigo.service;

import com.kodigo.model.Movimiento;
import com.kodigo.model.dto.ReporteDTO;
import com.kodigo.model.dto.CriteriosReporteDTO;

public interface IMovimientoService extends ICRUD<Movimiento, Integer> {

	Movimiento registrarTransaccional(Movimiento movimiento);
	
	ReporteDTO generarReporte(CriteriosReporteDTO criterios);
}