package com.backend.alianza.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaRepresentante")
public class FichaRepresentante {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaRepresentante")
    private Long idFichaRepresentante;

    @Column(name = "nombresRepre")
    private String nombresRepre;

    @Column(name = "apellidosRepre")
    private String apellidosRepre;

    @Column(name = "cedulaRepre")
    private String cedulaRepre;

    @Column(name = "contactoRepre")
    private String contactoRepre;

    @Column(name = "contactoEmergenciaRepre")
    private String contactoEmergenciaRepre;

    @Column(name = "fechaNacimientoRepre")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaNacimientoRepre;

    @Column(name = "ocupacionPrimariaRepre")
    private String ocupacionPrimariaRepre;

    @Column(name = "ocupacionSecundariaRepre")
    private String ocupacionSecundariaRepre;

    @Column(name = "lugarTrabajoRepre")
    private String lugarTrabajoRepre;

    @Column(name = "observacionesRepre")
    private String observacionesRepre;

    @Column(name = "nivelInstruccionRepre")
    private String nivelInstruccionRepre;

    @Column(name = "parentescoRepre")
    private String parentescoRepre;

    private String tipoIdentificacionRepre;

    private String generoRepre;

    private String nacionalidadRepre;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.sql.Date fechaRegistro;

    @Column(name = "anexosCedulaPPFF", columnDefinition = "TEXT")
    private String anexosCedulaPPFF;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;

    @OneToMany(mappedBy = "fichaRepresentante", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoRepresentante> anexoRepresentantes;
}
