package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.models.dtos.AtencionCreacionDTO;

import java.util.List;

public interface AtencionService {
    List<Atencion> findAll();
    Atencion findById(Long id);
    Atencion save(AtencionCreacionDTO atencion);


}
