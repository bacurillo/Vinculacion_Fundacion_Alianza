package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaEducativa")
public class FichaEducativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaEducativa")
    private Long idFichaEducativa;

    @Column(name = "centroEducativo")
    private String centroEducativo;

    @Column(name = "direccionEducativa")
    private String direccionEducativa;

    @Column(name = "referenciaEducativa")
    private String referenciaEducativa;

    @Column(name = "jornadaEducativa")
    private String jornadaEducativa;

    @Column(name = "observacionesEducativa")
    private String observacionesEducativa;

    @Column(name = "gradoEducativo")
    private String gradoEducativo;

    private boolean repitente;

    private String detalleRepitente;

    private String situacionPsicopedagogica;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaRegistro;

    @Column(name = "anexosMatricula", columnDefinition = "TEXT")
    private String anexosMatricula;

    @Column(name = "anexosCalificaciones1", columnDefinition = "TEXT")
    private String anexosCalificaciones1;

    @Column(name = "anexosCalificaciones2", columnDefinition = "TEXT")
    private String anexosCalificaciones2;

    @Column(name = "anexosCalificaciones3", columnDefinition = "TEXT")
    private String anexosCalificaciones3;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;

    @OneToMany(mappedBy = "fichaEducativa", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CursoGrado> cursoGrados;

    @OneToMany(mappedBy = "fichaEducativa", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoEducativo> anexoEducativos;
}
