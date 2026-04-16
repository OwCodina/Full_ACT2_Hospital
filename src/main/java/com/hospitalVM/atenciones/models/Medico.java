package com.hospitalVM.atenciones.models;

import com.hospitalVM.atenciones.models.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medico_id")
    private Long medicoId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo rut no puede estar vaco")
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El formato del rut tiene que ser XXXXXXXX-X")
    private String run;

    @Column(nullable = false, name = "nombre_completo")
    @NotBlank(message = "El campo nombre completo no puede estar vacio")
    private String nombreCompleto;

    @Column(name="jefe_turno", nullable = false)
    @NotNull(message = "El campo de jefe de turno no puede ser nulo")
    private Boolean jefeTurno;

    @Embedded
    private Audit audit = new Audit();
}
