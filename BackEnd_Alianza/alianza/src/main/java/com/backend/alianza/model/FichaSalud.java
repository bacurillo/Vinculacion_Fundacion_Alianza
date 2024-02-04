package com.backend.alianza.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaSalud")
public class FichaSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaSalud")
    private Long idFichaSalud;

    @Column(name = "condicionesMedicas")
    private String condicionesMedicas;

    private String condicionesMedicas2;

    private String condicionesMedicas3;

    private String condicionesMedicas4;

    private String condicionesMedicas5;

    private String condicionesMedicasAdd;

    private boolean carnetDiscapacidad;

    private double masaCorporal;

    private String situacionPsicoemocional;

    @Column(name = "pesoFichaSalud")
    private double pesoFichaSalud;

    @Column(name = "tallaFichaSalud")
    private double tallaFichaSalud;

    @Column(name = "discapacidadNNAFichaSalud")
    private Boolean discapacidadNNAFichaSalud;

    @Column(name = "tipoDiscapacidadFichaSalud")
    private String tipoDiscapacidadFichaSalud;

    @Column(name = "porcentajeDiscapacidadFichaSalud")
    private double porcentajeDiscapacidadFichaSalud;

    @Column(name = "enfermedadesPrevalentesFichaSalud")
    private String enfermedadesPrevalentesFichaSalud;

    @Column(name = "anexosCertificadoSalud", columnDefinition = "TEXT")
    private String anexosCertificadoSalud;

    @Column(name = "anexosCertificadoSalud2", columnDefinition = "TEXT")
    private String anexosCertificadoSalud2;

    @Column(name = "anexosDiscapacidad", columnDefinition = "TEXT")
    private String anexosDiscapacidad;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaRegistro;


    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;

    @OneToMany(mappedBy = "fichaSalud", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoMedico> anexoMedicos;

}
