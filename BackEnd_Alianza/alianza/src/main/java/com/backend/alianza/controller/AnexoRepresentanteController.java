package com.backend.alianza.controller;

import com.backend.alianza.model.AnexoRepresentante;
import com.backend.alianza.service.AnexoRepresentanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexoRepresentante")
@CrossOrigin(origins = {"*"})
public class AnexoRepresentanteController {

    @Autowired
    AnexoRepresentanteServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<AnexoRepresentante>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AnexoRepresentante> create(@RequestBody AnexoRepresentante a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<AnexoRepresentante> update(@PathVariable Long id, @RequestBody AnexoRepresentante a) {
        AnexoRepresentante anexo = anexoService.findById(id);
        if (anexo != null) {
            try {
                anexo.setDocumentoAnexo(a.getDocumentoAnexo());
                anexo.setFichaRepresentante(a.getFichaRepresentante());
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
    public ResponseEntity<AnexoRepresentante> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
