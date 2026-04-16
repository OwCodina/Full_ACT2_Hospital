package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.MedicoException;
import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.repositories.MedicoRepository;
import com.hospitalVM.atenciones.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Medico> findAll() {
        return this.medicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Medico findById(Long id) {
        return this.medicoRepository.findById(id).orElseThrow(
                () -> new MedicoException("Medico no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Medico findByRun(String run) {
        return this.medicoRepository.findByRun(run).orElseThrow(
                () -> new MedicoException("Medico no encontrado")
        );
    }

    @Transactional
    @Override
    public Medico save(Medico medico) {
        if (this.medicoRepository.findByRun(medico.getRun()).isPresent()){
            throw new MedicoException("Medico existente");
        }
        return this.medicoRepository.save(medico);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.medicoRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Medico updateById(Long id, Medico medico) {
        return this.medicoRepository.findById(id).map(element -> {
            // element.setRun(medico.getRun());
            element.setNombreCompleto(medico.getNombreCompleto());
            element.setJefeTurno(medico.getJefeTurno());
            return this.medicoRepository.save(element);
        }).orElseThrow(
                () -> new MedicoException("Medico no encontrado")
        );
    }
}
