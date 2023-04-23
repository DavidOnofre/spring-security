package com.kodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodigo.util.Constantes;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = Constantes.TABLA_CLIENTE)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = Constantes.USUARIO, nullable = false, unique = true)
    private String usuario;

    @NotNull
    @Size(min = 8, message = Constantes.CLAVE_TENER_MINIMO_8_CARACTERES)
    @Column(name = Constantes.CLAVE, nullable = false, length = 70)
    private String clave;

    @NotNull
    @Column(name = Constantes.ESTADO, nullable = false)
    private Boolean estado;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = Constantes.ID_PERSONA, nullable = false, foreignKey = @ForeignKey(name = Constantes.FK_CLIENTE_PERSONA))
    private Persona persona;

}
