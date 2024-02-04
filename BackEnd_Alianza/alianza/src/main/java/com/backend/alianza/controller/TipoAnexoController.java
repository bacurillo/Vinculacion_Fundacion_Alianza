package com.backend.alianza.controller;

import com.backend.alianza.model.AnexoMedico;
import com.backend.alianza.model.TipoAnexo;
import com.backend.alianza.service.TipoAnexoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoAnexo")
@CrossOrigin(origins = {"*"})
public class TipoAnexoController {

    @Autowired
    TipoAnexoServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<TipoAnexo>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<TipoAnexo> create(@RequestBody TipoAnexo a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

//    @PutMapping("/put/{id}")
//    public ResponseEntity<AnexoMedico> update(@PathVariable Long id, @RequestBody AnexoMedico a) {
//        TipoAnexo anexo = anexoService.findById(id);
//        if (anexo != null) {
//            try {
//                anexo.setFichaAnexo(a.getFichaAnexo());
//                anexo.setNombreTipoAnexo(a.getNombreTipoAnexo());
//                return new ResponseEntity<>(anexoService.save(anexo), HttpStatus.CREATED);
//            } catch (Exception e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TipoAnexo> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
