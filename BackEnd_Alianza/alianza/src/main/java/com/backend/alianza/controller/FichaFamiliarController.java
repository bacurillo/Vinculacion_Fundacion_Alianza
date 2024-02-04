package com.backend.alianza.controller;

import com.backend.alianza.model.FichaFamiliar;
import com.backend.alianza.service.FichaFamiliarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaFamiliar")
public class FichaFamiliarController {
    @Autowired
    public FichaFamiliarServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<FichaFamiliar>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaFamiliar>> busquedaID(@PathVariable Long id){

        return new ResponseEntity<>(service.busquedaID(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaFamiliar> create(@RequestBody FichaFamiliar ff) {
        return new ResponseEntity<>(service.save(ff), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaFamiliar> update(@PathVariable Long id, @RequestBody FichaFamiliar ff) {
        FichaFamiliar fichaFamiliar = service.findById(id);
        if (fichaFamiliar != null) {
            try {
                fichaFamiliar.setVisitaDomiciliaria(ff.isVisitaDomiciliaria());
                fichaFamiliar.setJefaturaFamiliar(ff.getJefaturaFamiliar());
                fichaFamiliar.setNumIntegrantes(ff.getNumIntegrantes());
                fichaFamiliar.setNumAdultos(ff.getNumAdultos());
                fichaFamiliar.setNumNNA(ff.getNumNNA());
                fichaFamiliar.setNumAdultosMayores(ff.getNumAdultosMayores());
                fichaFamiliar.setBeneficioAdicional(ff.getBeneficioAdicional());
                fichaFamiliar.setOrganizacionBeneficio(ff.getOrganizacionBeneficio());
                fichaFamiliar.setDiscapacidadIntegrantes(ff.isDiscapacidadIntegrantes());
                fichaFamiliar.setOtrasSituaciones(ff.getOtrasSituaciones());
                fichaFamiliar.setFichaPersonal(ff.getFichaPersonal());
                fichaFamiliar.setTipoFamilia(ff.getTipoFamilia());
                fichaFamiliar.setFechaRegistro(ff.getFechaRegistro());
                fichaFamiliar.setBeneficio(ff.isBeneficio());
                fichaFamiliar.setDetalleDiscapacidad(ff.getDetalleDiscapacidad());


                return new ResponseEntity<>(service.save(fichaFamiliar), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaFamiliar> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
