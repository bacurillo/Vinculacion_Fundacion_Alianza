package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.AnexoMedico;
import com.backend.alianza.repository.AnexoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoMedicoServiceImpl extends GenericServiceImpl<AnexoMedico, Long> implements GenericService<AnexoMedico, Long> {

    @Autowired
    AnexoMedicoRepository anexoRepository;

    @Override
    public CrudRepository<AnexoMedico, Long> getDao() {
        return anexoRepository;
    }
}
