package com.backend.alianza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Reporte {

    private FichaPersonal fichaPersonal;

    private FichaDesvinculacion fichaDesvinculacion;

    private FichaEducativa fichaEducativa;

    private FichaFamiliar fichaFamiliar;

    private FichaInscripcion fichaInscripcion;

    private FichaRepresentante fichaRepresentante;

    private FichaSalud fichaSalud;

    public Reporte() {
    }

    public Reporte(FichaPersonal fichaPersonal, FichaDesvinculacion fichaDesvinculacion, FichaEducativa fichaEducativa, FichaFamiliar fichaFamiliar, FichaInscripcion fichaInscripcion, FichaRepresentante fichaRepresentante, FichaSalud fichaSalud) {
        this.fichaPersonal = fichaPersonal;
        this.fichaDesvinculacion = fichaDesvinculacion;
        this.fichaEducativa = fichaEducativa;
        this.fichaFamiliar = fichaFamiliar;
        this.fichaInscripcion = fichaInscripcion;
        this.fichaRepresentante = fichaRepresentante;
        this.fichaSalud = fichaSalud;
    }

    public FichaPersonal getFichaPersonal() {
        return fichaPersonal;
    }

    public void setFichaPersonal(FichaPersonal fichaPersonal) {
        this.fichaPersonal = fichaPersonal;
    }

    public FichaDesvinculacion getFichaDesvinculacion() {
        return fichaDesvinculacion;
    }

    public void setFichaDesvinculacion(FichaDesvinculacion fichaDesvinculacion) {
        this.fichaDesvinculacion = fichaDesvinculacion;
    }

    public FichaEducativa getFichaEducativa() {
        return fichaEducativa;
    }

    public void setFichaEducativa(FichaEducativa fichaEducativa) {
        this.fichaEducativa = fichaEducativa;
    }

    public FichaFamiliar getFichaFamiliar() {
        return fichaFamiliar;
    }

    public void setFichaFamiliar(FichaFamiliar fichaFamiliar) {
        this.fichaFamiliar = fichaFamiliar;
    }

    public FichaInscripcion getFichaInscripcion() {
        return fichaInscripcion;
    }

    public void setFichaInscripcion(FichaInscripcion fichaInscripcion) {
        this.fichaInscripcion = fichaInscripcion;
    }

    public FichaRepresentante getFichaRepresentante() {
        return fichaRepresentante;
    }

    public void setFichaRepresentante(FichaRepresentante fichaRepresentante) {
        this.fichaRepresentante = fichaRepresentante;
    }

    public FichaSalud getFichaSalud() {
        return fichaSalud;
    }

    public void setFichaSalud(FichaSalud fichaSalud) {
        this.fichaSalud = fichaSalud;
    }
}
