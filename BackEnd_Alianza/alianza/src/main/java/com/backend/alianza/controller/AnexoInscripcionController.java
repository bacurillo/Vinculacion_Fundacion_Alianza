package com.backend.alianza.controller;

import com.backend.alianza.model.AnexoInscripcion;
import com.backend.alianza.service.AnexoInscripcionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexoInscripcion")
@CrossOrigin(origins = {"*"})
public class AnexoInscripcionController {

    @Autowired
    AnexoInscripcionServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<AnexoInscripcion>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AnexoInscripcion> create(@RequestBody AnexoInscripcion a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<AnexoInscripcion> update(@PathVariable Long id, @RequestBody AnexoInscripcion a) {
        AnexoInscripcion anexo = anexoService.findById(id);
        if (anexo != null) {
            try {
                anexo.setDocumentoAnexo(a.getDocumentoAnexo());
                anexo.setFichaInscripcion(a.getFichaInscripcion());
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
    public ResponseEntity<AnexoInscripcion> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
