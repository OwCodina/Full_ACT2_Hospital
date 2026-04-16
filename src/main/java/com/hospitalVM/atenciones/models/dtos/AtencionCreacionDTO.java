package com.hospitalVM.atenciones.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AtencionCreacionDTO {

    @NotNull(message = "El campo de hora atención no puede ser vacio")
    private LocalDateTime horaAtencion;

    @NotNull(message = "El campo de costo no puede ser vacio")
    private Double costo;

    private String comentario;

    @NotNull(message = "El campo medico no puede ser vacio")
    private Long medicoId;

    @NotNull(message = "El campo paciente no puede ser vacio")
    private Long pacienteId;


}
