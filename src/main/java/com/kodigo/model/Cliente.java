package com.kodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull
    @Size(min = 8, message = "Clave debe tener mínimo 8 caracteres")
    @Column(name = "clave", nullable = false, length = 70)
    private String clave;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_persona"))
    private Persona persona;

}
