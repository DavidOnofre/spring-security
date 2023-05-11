package com.kodigo.service.impl;

import com.kodigo.exception.ModeloNotFoundException;
import com.kodigo.model.Cuenta;
import com.kodigo.model.Movimiento;
import com.kodigo.model.Persona;
import com.kodigo.model.dto.CriteriosReporteDTO;
import com.kodigo.model.dto.MovimientoDTO;
import com.kodigo.model.dto.ReporteDTO;
import com.kodigo.repo.ICuentaRepo;
import com.kodigo.repo.IGenericRepo;
import com.kodigo.repo.IPersonaRepo;
import com.kodigo.repo.IReporteRepo;
import com.kodigo.service.IReporteService;
import com.kodigo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteServiceImpl extends CRUDImpl<Movimiento, Integer> implements IReporteService {

    @Autowired
    private IReporteRepo reporteRepo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    private ICuentaRepo cuentaRepo;

    @Override
    protected IGenericRepo<Movimiento, Integer> getRepo() {
        return reporteRepo;
    }

    @Override
    public ReporteDTO generarReporte(CriteriosReporteDTO criterios) {

        ReporteDTO reporteDTO = new ReporteDTO();
        List<Movimiento> movimientos = obtenerMovimientos(criterios);

        List<MovimientoDTO> movimientoDTOList = new ArrayList<>();
        for (Movimiento movimiento : movimientos) {

            Persona persona = obtenerPersona(criterios.getIdCliente());
            Cuenta cuenta = obtenerCuenta(movimiento.getCuenta().getIdCuenta());

            reporteDTO.setCliente(persona.getNombre());

            reporteDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
            reporteDTO.setTipoCuenta(cuenta.getTipoCuenta());
            reporteDTO.setEstado(cuenta.getEstado());
            reporteDTO.setSaldoInicial(cuenta.getSaldoInicial());
            reporteDTO.setSaldoDisponible(movimiento.getSaldo());

            MovimientoDTO movimientoDTO = new MovimientoDTO();
            movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
            movimientoDTO.setValor(movimiento.getValor());
            movimientoDTO.setFecha(movimiento.getFecha());
            movimientoDTOList.add(movimientoDTO);

            reporteDTO.setMovimientos(movimientoDTOList);

        }

        return reporteDTO;
    }

    private List<Movimiento> obtenerMovimientos(CriteriosReporteDTO criterios) {
        List<Movimiento> movimientos = reporteRepo.obtenerReporte(criterios.getFechaDesde(), criterios.getFechaHasta(), criterios.getIdCliente());
        if (movimientos.size() == 0) {
            throw new ModeloNotFoundException(Constantes.SIN_REGISTRO_REPORTE + criterios.getIdCliente());
        }
        return movimientos;
    }

    private Persona obtenerPersona(Integer idCliente) {
        Optional<Persona> optional = personaRepo.findById(idCliente);
        return optional.get();
    }

    private Cuenta obtenerCuenta(Integer idCuenta) {
        Optional<Cuenta> cuentaOptional = cuentaRepo.findById(idCuenta);
        return cuentaOptional.get();
    }

}
