package com.backend.alianza.controller;

import com.backend.alianza.model.TipoFamilia;
import com.backend.alianza.service.TipoFamiliaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoFamilia")
public class TipoFamiliaController {

    @Autowired
    public TipoFamiliaServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<TipoFamilia>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<TipoFamilia> create(@RequestBody TipoFamilia tf) {
        return new ResponseEntity<>(service.save(tf), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<TipoFamilia> update(@PathVariable Long id, @RequestBody TipoFamilia tf) {
        TipoFamilia tipoFamilia = service.findById(id);
        if (tipoFamilia != null) {
            try {
                tipoFamilia.setNombreTipo(tf.getNombreTipo());
                tipoFamilia.setFichaFamiliars(tf.getFichaFamiliars());

                return new ResponseEntity<>(service.save(tipoFamilia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TipoFamilia> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
