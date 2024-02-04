package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.AnexoPersonal;
import com.backend.alianza.repository.AnexoPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoPersonalServiceImpl extends GenericServiceImpl<AnexoPersonal, Long> implements GenericService<AnexoPersonal, Long> {

    @Autowired
    AnexoPersonalRepository anexoRepository;

    @Override
    public CrudRepository<AnexoPersonal, Long> getDao() {
        return anexoRepository;
    }
}
