package com.kodigo.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CuentaDTO {

    private String numeroCuenta;
    private String tipoCuenta;
    private Boolean estado;
    private BigDecimal saldoInicial;

    private List<MovimientoDTO> movimientos;

}
