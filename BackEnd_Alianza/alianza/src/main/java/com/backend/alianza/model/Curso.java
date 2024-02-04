package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class Curso implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    private String nombreCurso;

    @Column(name = "fechaInicio")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "idRangoEdad", referencedColumnName = "idRangoEdad")
    private RangoEdad rangoEdad;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario docente;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.sql.Date fechaRegistro;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaInscripcion> fichaInscripcions;




}
