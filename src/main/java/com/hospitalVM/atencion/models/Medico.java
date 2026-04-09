package com.hospitalVM.atencion.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medico_id")
    private Long medicoId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo rut no puede estar vacio")
    @Pattern(regexp = "\\d{1,8}-[\\dkk]",message = "El formato del rut tiene que ser xxxxxxxx-x")
    private String run;


    @Column(nullable = false, name = "nombre_completo")
    @NotBlank(message = "El campo no puede estar vacio")
    private String nombreCompleto;

    @Column(name = "jefe_turno", nullable = false)
    @NotNull(message = "El campo no puede ser nulo")
    private Boolean jefeTurno;
}
