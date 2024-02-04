package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaInscripcion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFichaInscripcion")
public class FichaInscripcion implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaInscripcion")
    private Long idFichaInscripcion;

    @Column(name = "fechaIngresoInscrip")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaIngresoInscrip;

    @Column(name = "proyectoInscrip")
    private String proyectoInscrip;

    @Column(name = "situacionIngresoInscrip")
    private String situacionIngresoInscrip;

    @Column(name = "asistenciaInscrip")
    private String asistenciaInscrip;

    @Column(name = "jornadaAsistenciaInscrip")
    private String jornadaAsistenciaInscrip;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.sql.Date fechaRegistro;

    @Column(name = "anexosFichaSocioEconomica", columnDefinition = "TEXT")
    private String anexosFichaSocioEconomica;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    @JsonIgnoreProperties("fichaInscripcions") // Evita la referencia circular
    private FichaPersonal fichaPersonal;

    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    @JsonIgnoreProperties("inscripciones") // Evita la referencia circular
    private Curso curso;

    @OneToMany(mappedBy = "fichaInscripcion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "fichaInscripcion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoInscripcion> anexosInscripcions;
}
