package com.kodigo.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriteriosReporteDTO {

    private Integer idCliente;
    private LocalDateTime fechaDesde;
    private LocalDateTime fechaHasta;

}
