package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Encargado;
import com.backend.alianza.repository.EncargadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EncargadoServiceImpl extends GenericServiceImpl<Encargado, Long> implements GenericService<Encargado, Long> {
    @Autowired
    private EncargadoRepository encargadoRepository;

    @Override
    public CrudRepository<Encargado, Long> getDao() {
        return encargadoRepository;
    }
}
