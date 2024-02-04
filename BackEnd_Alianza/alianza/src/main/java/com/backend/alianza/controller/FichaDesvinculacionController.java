package com.backend.alianza.controller;


import com.backend.alianza.model.FichaDesvinculacion;
import com.backend.alianza.service.FichaDesvinculacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaDesvinculacion")
@CrossOrigin(origins = {"*"})
public class FichaDesvinculacionController {
    @Autowired
    FichaDesvinculacionServiceImpl fichaDesvinculacionService;

    @GetMapping("/get")
    public ResponseEntity<List<FichaDesvinculacion>> list() {
        return new ResponseEntity<>(fichaDesvinculacionService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaDesvinculacion>> busquedaID(@PathVariable Long id){

        return new ResponseEntity<>(fichaDesvinculacionService.busquedaID(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaDesvinculacion> create(@RequestBody FichaDesvinculacion a) {
        return new ResponseEntity<>(fichaDesvinculacionService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaDesvinculacion> update(@PathVariable Long id, @RequestBody FichaDesvinculacion a) {
        FichaDesvinculacion fichaDesvinculacion = fichaDesvinculacionService.findById(id);
        if (fichaDesvinculacion != null) {
            try {
                fichaDesvinculacion.setFechaDesvinculacion(a.getFechaDesvinculacion());
                fichaDesvinculacion.setAnexosExtras(a.getAnexosExtras());
                fichaDesvinculacion.setMotivo(a.getMotivo());
                fichaDesvinculacion.setFichaPersonal(a.getFichaPersonal());
                fichaDesvinculacion.setFechaRegistro(a.getFechaRegistro());

                return new ResponseEntity<>(fichaDesvinculacionService.save(fichaDesvinculacion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaDesvinculacion> delete(@PathVariable Long id) {
        fichaDesvinculacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
