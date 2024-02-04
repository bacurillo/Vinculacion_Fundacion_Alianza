package com.backend.alianza.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaFamiliar")
public class FichaFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFichaFamiliar;

    private boolean visitaDomiciliaria;

    private String jefaturaFamiliar;

    private int numIntegrantes;

    private int numAdultos;

    private int numNNA;

    private int numAdultosMayores;

    private String beneficioAdicional;

    private String organizacionBeneficio;

    private boolean discapacidadIntegrantes;

    private boolean beneficio;

    private String otrasSituaciones;

    private String detalleDiscapacidad;


    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idTipoFamilia", referencedColumnName = "idTipoFamilia")
    private TipoFamilia tipoFamilia;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;

}
