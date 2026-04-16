package com.hospitalVM.atenciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "atenciones")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atencion_id")
    private Long atencionId;

    @NotNull(message = "El campo de hora atención no puede ser vacio")
    @Column(name="hora_atencion", nullable = false)
    private LocalDateTime horaAtencion;

    @NotNull(message = "El campo de costo no puede ser vacio")
    @Column(nullable = false)
    private Double costo;

    private String comentario;

    @NotNull(message = "El campo medico no puede ser vacio")
    @ManyToOne
    @JoinColumn(name="medico_id", nullable = false)
    private Medico medico;

    @NotNull(message = "El campo paciente no puede ser vacio")
    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;

}
