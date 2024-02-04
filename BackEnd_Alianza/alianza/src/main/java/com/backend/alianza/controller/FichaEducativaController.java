package com.backend.alianza.controller;

import com.backend.alianza.model.FichaEducativa;
import com.backend.alianza.service.FichaEducativaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaEducativa")
@CrossOrigin(origins = {"*"})
public class FichaEducativaController {
    @Autowired
    FichaEducativaServiceImpl fichaEducativaService;

    @GetMapping("/get")
    public ResponseEntity<List<FichaEducativa>> list() {
        return new ResponseEntity<>(fichaEducativaService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaEducativa>> busquedaID(@PathVariable Long id) {

        return new ResponseEntity<>(fichaEducativaService.busquedaID(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaEducativa> create(@RequestBody FichaEducativa a) {
        return new ResponseEntity<>(fichaEducativaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaEducativa> update(@PathVariable Long id, @RequestBody FichaEducativa a) {
        FichaEducativa fichaEducativa = fichaEducativaService.findById(id);
        if (fichaEducativa != null) {
            try {
                fichaEducativa.setCentroEducativo(a.getCentroEducativo());
                fichaEducativa.setReferenciaEducativa(a.getReferenciaEducativa());
                fichaEducativa.setJornadaEducativa(a.getJornadaEducativa());
                fichaEducativa.setObservacionesEducativa(a.getObservacionesEducativa());
                fichaEducativa.setGradoEducativo(a.getGradoEducativo());
                fichaEducativa.setDireccionEducativa(a.getDireccionEducativa());
                fichaEducativa.setFichaPersonal(a.getFichaPersonal());
                fichaEducativa.setFechaRegistro(a.getFechaRegistro());
                fichaEducativa.setRepitente(a.isRepitente());
                fichaEducativa.setDetalleRepitente(a.getDetalleRepitente());
                fichaEducativa.setSituacionPsicopedagogica(a.getSituacionPsicopedagogica());
                fichaEducativa.setAnexosMatricula(a.getAnexosMatricula());
                fichaEducativa.setAnexosCalificaciones1(a.getAnexosCalificaciones1());
                fichaEducativa.setAnexosCalificaciones2(a.getAnexosCalificaciones2());
                fichaEducativa.setAnexosCalificaciones3(a.getAnexosCalificaciones3());
                return new ResponseEntity<>(fichaEducativaService.save(fichaEducativa), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaEducativa> delete(@PathVariable Long id) {
        fichaEducativaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
