package com.backend.alianza.controller;

import com.backend.alianza.model.AnexoPersonal;
import com.backend.alianza.service.AnexoPersonalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexoPersonal")
@CrossOrigin(origins = {"*"})
public class AnexoPersonalController {

    @Autowired
    AnexoPersonalServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<AnexoPersonal>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AnexoPersonal> create(@RequestBody AnexoPersonal a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<AnexoPersonal> update(@PathVariable Long id, @RequestBody AnexoPersonal a) {
        AnexoPersonal anexo = anexoService.findById(id);
        if (anexo != null) {
            try {
                anexo.setDocumentoAnexo(a.getDocumentoAnexo());
                anexo.setFichaPersonal(a.getFichaPersonal());
                anexo.setTipoAnexo(a.getTipoAnexo());
                anexo.setFechaCarga(a.getFechaCarga());
                anexo.setOtroTipoAnexo(a.getOtroTipoAnexo());
                return new ResponseEntity<>(anexoService.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AnexoPersonal> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
