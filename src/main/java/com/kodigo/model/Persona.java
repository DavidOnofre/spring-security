package com.kodigo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @NotNull
    @Size(min = 3, message = "Nombres debe tener mínimo 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @NotNull
    @Size(min = 1, max = 1, message = "Tag genero acepta M: masculino, F: femenino")
    @Column(name = "genero", nullable = false, length = 1)
    private String genero;

    @NotNull
    @Column(name = "edad", nullable = false)
    private Integer edad;

    @NotNull
    @Size(min = 10, max = 10, message = "Identificación debe tener 10 caracteres")
    @Column(name = "identificacion", nullable = false, length = 10)
    private String identificacion;

    @NotNull
    @Size(max = 150, message = "Dirección acepta hasta 150 caracteres")
    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    @NotNull
    @Size(min = 10, max = 10, message = "Identificación debe tener 10 caracteres")
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

}
