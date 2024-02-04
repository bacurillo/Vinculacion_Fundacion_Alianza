package com.backend.alianza.model;

import javax.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaDesvinculacion")
public class FichaDesvinculacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaDesvinculacion")
    private long idFichaDesvinculacion;

    @Column(name = "fechaDesvinculacion")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaDesvinculacion;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaRegistro;

    @Column(name = "motivoDesvinculacion")
    private String motivo;

    @Column(name = "anexosExtrasDesvinculacion", columnDefinition = "TEXT")
    private String anexosExtras;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;


}
