package com.kodigo.model;

import com.kodigo.util.Constantes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = Constantes.TABLA_PERSONA)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @NotNull
    @Schema(description = Constantes.NOMBRE_DEBE_TENER_MINIMO_3_CARACTERES)
    @Size(min = 3, message = Constantes.NOMBRE_DEBE_TENER_MINIMO_3_CARACTERES)
    @Column(name = Constantes.NOMBRE, nullable = false, length = 70)
    private String nombre;

    @NotNull
    @Schema(description = Constantes.GENERO_ACEPTA_MASCULINO_FEMENINO)
    @Size(min = 1, max = 1, message = Constantes.GENERO_ACEPTA_MASCULINO_FEMENINO)
    @Column(name = Constantes.GENERO, nullable = false, length = 1)
    private String genero;

    @NotNull
    @Column(name = Constantes.EDAD, nullable = false)
    private Integer edad;

    @NotNull
    @Schema(description = Constantes.IDENTIFICACION_DEBE_TENER_10_CARACTERES)
    @Size(min = 10, max = 10, message = Constantes.IDENTIFICACION_DEBE_TENER_10_CARACTERES)
    @Column(name = Constantes.IDENTIFICACION, nullable = false, length = 10)
    private String identificacion;

    @NotNull
    @Schema(description = Constantes.DIRECCION_ACEPTA_HASTA_150_CARACTERES)
    @Size(max = 150, message = Constantes.DIRECCION_ACEPTA_HASTA_150_CARACTERES)
    @Column(name = Constantes.DIRECCION, nullable = false, length = 150)
    private String direccion;

    @NotNull
    @Schema(description = Constantes.TELEFONO_DEBE_TENER_10_CARACTERES)
    @Size(min = 10, max = 10, message = Constantes.TELEFONO_DEBE_TENER_10_CARACTERES)
    @Column(name = Constantes.TELEFONO, nullable = false, length = 10)
    private String telefono;

}
