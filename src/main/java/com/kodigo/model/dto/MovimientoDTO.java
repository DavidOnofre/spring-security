package com.kodigo.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimientoDTO {

    private String tipoMovimiento;
    private BigDecimal valor;
    private LocalDateTime fecha;

}
