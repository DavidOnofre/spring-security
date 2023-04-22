package com.kodigo.model;

import java.math.BigDecimal;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodigo.util.Constantes;
import lombok.Data;

@Data
@Entity
@Table(name = Constantes.TABLA_CUENTA)
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @NotNull
    @Size(min = 10, max = 10, message = Constantes.CUENTA_DEBE_TENER_10_DIGITOS)
    @Column(name = Constantes.NUMERO_CUENTA, nullable = false, length = 10)
    private String numeroCuenta;

    @NotNull
    @Size(min = 3, max = 3, message = Constantes.TIPO_CUENTA_PERMITIDOS)
    @Column(name = Constantes.TIPO_CUENTA, nullable = false, length = 3)
    private String tipoCuenta;

    @NotNull
    @Column(name = Constantes.SALDO_INICIAL, nullable = false)
    private BigDecimal saldoInicial;

    @Column(name = Constantes.SALDO_DISPONIBLE, nullable = false)
    private BigDecimal saldoDisponible;

    @NotNull
    @Column(name = Constantes.ESTADO, nullable = false)
    private Boolean estado;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = Constantes.ID_CLIENTE, nullable = false, foreignKey = @ForeignKey(name = Constantes.FK_CUENTA_CLIENTE))
    private Cliente cliente;
}
