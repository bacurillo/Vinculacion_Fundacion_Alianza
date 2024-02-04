package com.backend.alianza.controller;

import com.backend.alianza.model.AnexoEducativo;
import com.backend.alianza.service.AnexoEducativoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexoEducativo")
@CrossOrigin(origins = {"*"})
public class AnexoEducativoController {

    @Autowired
    AnexoEducativoServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<AnexoEducativo>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AnexoEducativo> create(@RequestBody AnexoEducativo a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<AnexoEducativo> update(@PathVariable Long id, @RequestBody AnexoEducativo a) {
        AnexoEducativo anexo = anexoService.findById(id);
        if (anexo != null) {
            try {
                anexo.setDocumentoAnexo(a.getDocumentoAnexo());
                anexo.setFichaEducativa(a.getFichaEducativa());
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
    public ResponseEntity<AnexoEducativo> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
