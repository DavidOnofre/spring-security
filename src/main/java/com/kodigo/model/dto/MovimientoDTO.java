package com.kodigo.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimientoDTO {

    private String tipoMovimiento;
    private BigDecimal valor;
    private LocalDateTime fecha;

}
