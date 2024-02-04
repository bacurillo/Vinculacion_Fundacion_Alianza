package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaPersonal")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFichaPersonal")
public class FichaPersonal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichaPersonal;

    @Column(name = "foto", columnDefinition = "TEXT")
    private String foto;

    private String apellidos;

    private String nombres;

    private String tipoIdentificacion;

    private String ciPasaporte;

    private String nacionalidad;

    private boolean actTrabInfantil;

    private String detalleActTrabInfantil;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaNacimiento;

    private String genero;

    private String zona;

    private String barrioSector;

    private String direccion;

    private String referencia;

    private double coordenadaX;

    private double coordenadaY;

    private boolean estVinculacion;

    @Column(name = "anexosCedula", columnDefinition = "TEXT")
    private String anexosCedula;

    @Column(name = "anexosDocumentosLegales", columnDefinition = "TEXT")
    private String anexosDocumentosLegales;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.sql.Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idRangoEdad", referencedColumnName = "idRangoEdad")
    private RangoEdad rangoEdad;

    @ManyToOne
    @JoinColumn(name = "idEtnia", referencedColumnName = "idEtnia")
    private Etnia etnia;

    @ManyToOne
    @JoinColumn(name = "idParroquia", referencedColumnName = "idParroquia")
    private Parroquia parroquia;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaDesvinculacion> fichaDesvinculacions;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoPersonal> anexosPersonales;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaSalud> fichaSaluds;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaRepresentante> fichaRepresentantes;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaEducativa> fichaEducativas;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaFamiliar> fichaFamiliars;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaInscripcion> fichaInscripcions;






}
