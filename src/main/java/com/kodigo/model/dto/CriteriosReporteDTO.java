package com.kodigo.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CriteriosReporteDTO {

    private Integer idCliente;
    private LocalDateTime fechaDesde;
    private LocalDateTime fechaHasta;

}
