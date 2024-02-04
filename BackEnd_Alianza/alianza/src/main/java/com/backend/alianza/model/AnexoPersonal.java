package com.backend.alianza.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anexoPersonal")
public class AnexoPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnexoPersonal")
    private Long idAnexoPersonal;

    @Column(name = "documentoAnexo", columnDefinition = "TEXT")
    private String documentoAnexo;

    @Column(name = "otroTipoAnexo")
    private String otroTipoAnexo;

    @Column(name = "fechaCarga")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaCarga;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;

    @ManyToOne
    @JoinColumn(name = "idTipoAnexo")
    private TipoAnexo tipoAnexo;

}
