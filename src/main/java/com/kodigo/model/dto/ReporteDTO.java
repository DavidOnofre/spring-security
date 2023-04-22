package com.kodigo.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ReporteDTO {

    private String cliente;

    private String numeroCuenta;
    private String tipoCuenta;
    private Boolean estado;
    private BigDecimal saldoInicial;
    private BigDecimal saldoDisponible;

    private List<MovimientoDTO> movimientos;

}
