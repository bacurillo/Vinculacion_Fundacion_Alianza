package com.backend.alianza.controller;


import com.backend.alianza.model.Rol;
import com.backend.alianza.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    RolService RolService;

    @PostMapping("/create")
    public ResponseEntity<Rol> crear(@RequestBody Rol obj) {
        try {
            return new ResponseEntity<>(RolService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Rol>> obtenerLista() {
        try {
            return new ResponseEntity<>(RolService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> actualizarCategoria(@PathVariable Long id, @RequestBody Rol obj) {
        Rol fndObj = RolService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setNombreRol(obj.getNombreRol());
                fndObj.setDescripcionRol(obj.getDescripcionRol());
                return new ResponseEntity<>(RolService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            RolService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Rol> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(RolService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
