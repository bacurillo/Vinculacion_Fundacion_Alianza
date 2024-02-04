package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.AnexoInscripcion;
import com.backend.alianza.repository.AnexoInscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoInscripcionServiceImpl extends GenericServiceImpl<AnexoInscripcion, Long> implements GenericService<AnexoInscripcion, Long> {

    @Autowired
    AnexoInscripcionRepository anexoRepository;

    @Override
    public CrudRepository<AnexoInscripcion, Long> getDao() {
        return anexoRepository;
    }
}
