package com.hospitalVM.atenciones.repositories;

import com.hospitalVM.atenciones.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByRut(String rut);

    Optional<Paciente> findByCorreo(String correo);
}
