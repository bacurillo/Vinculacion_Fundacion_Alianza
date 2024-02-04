package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaDesvinculacion;
import com.backend.alianza.repository.FichaDesvinculacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaDesvinculacionServiceImpl extends GenericServiceImpl<FichaDesvinculacion, Long> implements GenericService<FichaDesvinculacion, Long> {
    @Autowired
    FichaDesvinculacionRepository desvinculacionRepository;

    @Override
    public CrudRepository<FichaDesvinculacion, Long> getDao() {
        return desvinculacionRepository;
    }

    public List<FichaDesvinculacion> busquedaID(Long id) {
        return desvinculacionRepository.busquedaID(id);
    }


}
