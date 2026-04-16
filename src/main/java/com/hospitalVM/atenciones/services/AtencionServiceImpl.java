package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.MedicoException;
import com.hospitalVM.atenciones.exceptions.PacienteException;
import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.models.dtos.AtencionCreacionDTO;
import com.hospitalVM.atenciones.repositories.AtencionRespository;
import com.hospitalVM.atenciones.repositories.MedicoRepository;
import com.hospitalVM.atenciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    @Autowired
    private AtencionRespository atencionRespository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Atencion> findAll() {
        return this.atencionRespository.findAll();
    }

    @Override
    public Atencion findById(Long id) {
        return this.atencionRespository.findById(id).orElseThrow(

        );
    }


    @Override
    public Atencion save(AtencionCreacionDTO atencion) {
        Medico medico = this.medicoRepository.findById(atencion.getMedicoId()).orElseThrow(
                () -> new MedicoException("El medico con id "+atencion.getMedicoId()+" no existe")
        );

        Paciente paciente = this.pacienteRepository.findById(atencion.getPacienteId()).orElseThrow(
                () -> new PacienteException("El paciente con id "+atencion.getPacienteId()+" no existe")
        );

        Atencion atencionEntity = new Atencion();
        atencionEntity.setMedico(medico);
        atencionEntity.setPaciente(paciente);
        atencionEntity.setHoraAtencion(atencion.getHoraAtencion());
        atencionEntity.setComentario(atencion.getComentario());
        atencionEntity.setCosto(atencion.getCosto());
        return this.atencionRespository.save(atencionEntity);
    }
}

