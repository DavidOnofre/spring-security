package com.kodigo.model;

import com.kodigo.util.Constantes;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = Constantes.TABLA_MOVIMIENTO)
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimiento;

    @Column(name = Constantes.FECHA, nullable = false)
    private LocalDateTime fecha;

    @NotNull
    @Size(min = 3, max = 3, message = Constantes.TIPO_MOVIMIENTO_DEBE_TENER_3_CARACTERES)
    @Column(name = Constantes.TIPO_MOVIMIENTO, nullable = false, length = 3)
    private String tipoMovimiento;

    @NotNull
    @Column(name = Constantes.VALOR, nullable = false)
    private BigDecimal valor;

    @Column(name = Constantes.SALDO, nullable = false)
    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = Constantes.ID_CUENTA, nullable = false, foreignKey = @ForeignKey(name = Constantes.FK_MOVIMIENTO_CUENTA))
    private Cuenta cuenta;
}
