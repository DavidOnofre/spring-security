package com.kodigo.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.kodigo.model.dto.CuentaDTO;
import com.kodigo.model.dto.MovimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.exception.ModeloNotFoundException;
import com.kodigo.model.Cuenta;
import com.kodigo.model.Movimiento;
import com.kodigo.model.Persona;
import com.kodigo.model.dto.ReporteDTO;
import com.kodigo.model.dto.CriteriosReporteDTO;
import com.kodigo.repo.ICuentaRepo;
import com.kodigo.repo.IGenericRepo;
import com.kodigo.repo.IMovimientoRepo;
import com.kodigo.repo.IPersonaRepo;
import com.kodigo.service.IMovimientoService;

@Service
public class MovimientoServiceImpl extends CRUDImpl<Movimiento, Integer> implements IMovimientoService {

    @Autowired
    private IMovimientoRepo movimientoRepo;

    @Autowired
    private ICuentaRepo cuentaRepo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Override
    protected IGenericRepo<Movimiento, Integer> getRepo() {
        return movimientoRepo;
    }

    @Transactional
    @Override
    public Movimiento registrarTransaccional(Movimiento movimiento) {
        Cuenta cuenta = obtenerCuenta(movimiento);
        movimiento.setCuenta(cuenta);
        registrarSaldoCuenta(movimiento, cuenta);
        registrarMovimiento(movimiento, cuenta);
        return movimiento;
    }

    // Método que recupera la cuenta que se va a utilizar en un movimiento.
    private Cuenta obtenerCuenta(Movimiento movimiento) {
        Optional<Cuenta> cuentaOptional = cuentaRepo.findById(movimiento.getCuenta().getIdCuenta());
        return cuentaOptional.get();
    }

    // Método que dependiendo del tipo de movimiento suma o resta el valor del
    // movimiento.
    private void registrarMovimiento(Movimiento movimiento, Cuenta cuenta) {
        movimiento.setFecha(LocalDateTime.now());
        switch (movimiento.getTipoMovimiento()) {
            case "RET":

                movimiento.setSaldo(cuenta.getSaldoDisponible());
                movimientoRepo.save(movimiento);

                break;
            case "DEP":

                movimiento.setSaldo(cuenta.getSaldoDisponible());
                movimientoRepo.save(movimiento);

                break;
            default:
                throw new ModeloNotFoundException("Tag tipoMovimiento permitidos: retiro: RET / deposito: DEP ");
        }
    }

    // Método que dependiendo del tipo de movimiento suma o resta al saldo
    // disponible en la cuenta.
    private void registrarSaldoCuenta(Movimiento movimiento, Cuenta cuenta) {
        switch (movimiento.getTipoMovimiento()) {
            case "RET":

                BigDecimal saldoRetiro = cuenta.getSaldoDisponible().subtract(movimiento.getValor());
                if (saldoRetiro.compareTo(BigDecimal.ZERO) < 0) {
                    throw new ModeloNotFoundException("Saldo no disponible.");
                }

                cuenta.setSaldoDisponible(cuenta.getSaldoDisponible().subtract(movimiento.getValor()));
                cuentaRepo.save(cuenta);

                break;
            case "DEP":

                cuenta.setSaldoDisponible(cuenta.getSaldoDisponible().add(movimiento.getValor()));
                cuentaRepo.save(cuenta);

                break;
        }

    }

    @Override
    public ReporteDTO generarReporte(CriteriosReporteDTO criterios) {

        ReporteDTO reporteDTO = new ReporteDTO();
        List<Movimiento> movimientos = movimientoRepo.obtenerReporte(criterios.getFechaDesde(), criterios.getFechaHasta(), criterios.getIdCliente());
        if (movimientos.size() == 0) {
            throw new ModeloNotFoundException("Sin Registro: " + criterios.getIdCliente());
        }

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

    private Cuenta obtenerCuenta(Integer idCuenta) {
        Optional<Cuenta> cuentaOptional = cuentaRepo.findById(idCuenta);
        return cuentaOptional.get();
    }

    private Persona obtenerPersona(Integer idCliente) {
        Optional<Persona> optional = personaRepo.findById(idCliente);
        return optional.get();
    }

}
