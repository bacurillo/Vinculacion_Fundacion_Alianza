package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;

    @Column(name = "fechaAsistencia")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaAsistencia;

    private Boolean estadoAsistencia;

    private String observacionesAsistencia;

    @ManyToOne
    @JoinColumn(name = "idFichaInscripcion", referencedColumnName = "idFichaInscripcion")
    private FichaInscripcion fichaInscripcion;

    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    private Curso curso;

}
