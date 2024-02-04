package com.backend.alianza.controller;

import com.backend.alianza.model.FichaInscripcion;
import com.backend.alianza.model.Usuario;
import com.backend.alianza.service.FichaInscripcionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaInscripcion")
@CrossOrigin(origins = {"*"})
public class FichaInscripcionController {

    @Autowired
    FichaInscripcionServiceImpl fichaInscripcionService;

    @GetMapping("/get")
    public ResponseEntity<List<FichaInscripcion>> list() {
        return new ResponseEntity<>(fichaInscripcionService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaInscripcion>> busquedaID(@PathVariable Long id) {
        return new ResponseEntity<>(fichaInscripcionService.busquedaID(id), HttpStatus.OK);
    }

    @GetMapping("/listaEstudiantes")
    public ResponseEntity<List<FichaInscripcion>> listByID(@RequestParam("id") Long id) {

        return new ResponseEntity<>(fichaInscripcionService.listaEstudiantes(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaInscripcion> create(@RequestBody FichaInscripcion a) {
        return new ResponseEntity<>(fichaInscripcionService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaInscripcion> update(@PathVariable Long id, @RequestBody FichaInscripcion a) {
        FichaInscripcion fichaInscripcion = fichaInscripcionService.findById(id);
        if (fichaInscripcion != null) {
            try {
                fichaInscripcion.setAsistenciaInscrip(a.getAsistenciaInscrip());
                fichaInscripcion.setProyectoInscrip(a.getProyectoInscrip());
                fichaInscripcion.setFechaIngresoInscrip(a.getFechaIngresoInscrip());
                fichaInscripcion.setJornadaAsistenciaInscrip(a.getJornadaAsistenciaInscrip());
                fichaInscripcion.setSituacionIngresoInscrip(a.getSituacionIngresoInscrip());
                fichaInscripcion.setFechaRegistro(a.getFechaRegistro());
                fichaInscripcion.setFichaPersonal(a.getFichaPersonal());
                fichaInscripcion.setAnexosFichaSocioEconomica(a.getAnexosFichaSocioEconomica());
                return new ResponseEntity<>(fichaInscripcionService.save(fichaInscripcion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaInscripcion> delete(@PathVariable Long id) {
        fichaInscripcionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
