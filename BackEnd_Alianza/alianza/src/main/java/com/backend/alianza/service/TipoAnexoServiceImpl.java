package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.TipoAnexo;
import com.backend.alianza.repository.TipoAnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoAnexoServiceImpl extends GenericServiceImpl<TipoAnexo, Long> implements GenericService<TipoAnexo, Long> {

    @Autowired
    TipoAnexoRepository anexoRepository;

    @Override
    public CrudRepository<TipoAnexo, Long> getDao() {
        return anexoRepository;
    }
}
