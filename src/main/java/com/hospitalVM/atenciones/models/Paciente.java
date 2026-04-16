package com.hospitalVM.atenciones.models;

import com.hospitalVM.atenciones.models.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {

    /**
     * @Id -> Se define como la llave primaria del elemento
     * @GeneratedValue -> Nos permite generar un id de la primary key de forma automática
     * @Column -> Nos permite modificar la propiedad de un campo, por ejemplo que no se nulo
     * que tenga un valor único o como se llamará en la BD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    @NotBlank(message = "El campo rut no puede ser vacio")
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El formato del rut tiene que ser XXXXXXXX-X")
    @Column(unique = true, nullable = false)
    private String rut;

    @NotBlank(message = "El campo nombres no puede ser vacio")
    @Column(nullable = false)
    private String nombres;

    @NotBlank(message = "El campo apellidos no puede ser vacio")
    @Column(nullable = false)
    private String apellidos;

    @NotNull(message = "El campo de fecha nacimiento no puede ser vacio")
    @Column(nullable = false, name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Email(message = "El correo tiene que tener formato de correo")
    @NotBlank(message = "El correo no puede ser vacio")
    @Column(nullable = false, unique = true)
    private String correo;

    @Embedded
    com.hospitalVM.atenciones.models.Audit audit = new Audit();
}
