package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.AnexoRepresentante;
import com.backend.alianza.repository.AnexoRepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoRepresentanteServiceImpl extends GenericServiceImpl<AnexoRepresentante, Long> implements GenericService<AnexoRepresentante, Long> {

    @Autowired
    AnexoRepresentanteRepository anexoRepository;

    @Override
    public CrudRepository<AnexoRepresentante, Long> getDao() {
        return anexoRepository;
    }
}
