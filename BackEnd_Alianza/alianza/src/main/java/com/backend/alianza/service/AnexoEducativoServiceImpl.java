package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.AnexoEducativo;
import com.backend.alianza.repository.AnexoEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoEducativoServiceImpl extends GenericServiceImpl<AnexoEducativo, Long> implements GenericService<AnexoEducativo, Long> {

    @Autowired
    AnexoEducativoRepository anexoRepository;

    @Override
    public CrudRepository<AnexoEducativo, Long> getDao() {
        return anexoRepository;
    }
}
