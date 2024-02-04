package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.repository.FichaPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaPersonalServiceImpl extends GenericServiceImpl<FichaPersonal, Long> implements GenericService<FichaPersonal, Long> {

    @Autowired
    private FichaPersonalRepository repository;

    @Override
    public CrudRepository<FichaPersonal, Long> getDao() {
        return repository;
    }

    public List<FichaPersonal> busquedaRE(String ci, String gen, int rang, boolean est) {
        return repository.busquedaRE(ci, gen, rang, est);
    }

    public List<FichaPersonal> gelAllByEst(boolean est) {
        return repository.gelAllByEst(est);
    }

    public boolean cedulaUnicaFP(String ci) {
//        int cont = repository.cedulaUnicaFP(ci.trim());
//
//        if (cont > 0) {
//            return false;
//        } else {
//            return true;
//        }
        return repository.existsByCiPasaporte(ci.trim());
    }

    public List<Object[]> reporteGeneralRE(String ci, String gen, int rang, boolean est) {
        return repository.reporteGeneralRE(ci, gen, rang, est);
    }

    public List<Object[]> reporteGeneral(String ci, String gen,  boolean est) {
        return repository.reporteGeneral(ci, gen, est);
    }

    public List<FichaPersonal> busqueda(String ci, String gen, boolean est) {
        return repository.busqueda(ci, gen, est);
    }

//    public List<Object[]> busquedaReporte(String ci, String gen, boolean est) {
//        return repository.busquedaReporte(ci, gen, est);
//    }

    public List<Object[]> busquedaCiNombre(boolean est, String busqueda) {
        return repository.busquedaCiNombre(est, busqueda);
    }


    public List<FichaPersonal> busquedaFP(boolean est, String busqueda) {
        return repository.busquedaFP(est, busqueda);
    }

    public List<FichaPersonal> busquedaID(Long id) {
        return repository.busquedaID(id);
    }

}
