package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaEducativa;
import com.backend.alianza.repository.FichaEducativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaEducativaServiceImpl extends GenericServiceImpl<FichaEducativa,Long>implements GenericService<FichaEducativa,Long> {
    @Autowired
    FichaEducativaRepository fichaEducativaRepository;
    @Override
    public CrudRepository<FichaEducativa, Long> getDao() {
        return fichaEducativaRepository;
    }

    public List<FichaEducativa> busquedaID(Long id) {
        return fichaEducativaRepository.busquedaID(id);
    }
}
