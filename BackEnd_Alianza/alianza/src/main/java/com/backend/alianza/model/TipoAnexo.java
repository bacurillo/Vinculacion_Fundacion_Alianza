package com.backend.alianza.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipoAnexo")
public class TipoAnexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAnexo")
    private Long idTipoAnexo;

    @Column(name = "nombreTipoAnexo")
    private String nombreTipoAnexo;

    @Column(name = "fichaAnexo")
    private String fichaAnexo;

    @OneToMany(mappedBy = "tipoAnexo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoPersonal> anexosPersonales;

    @OneToMany(mappedBy = "tipoAnexo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoInscripcion> anexosInscripcions;

    @OneToMany(mappedBy = "tipoAnexo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoRepresentante> anexoRepresentantes;

    @OneToMany(mappedBy = "tipoAnexo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoEducativo> anexoEducativos;

    @OneToMany(mappedBy = "tipoAnexo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnexoMedico> anexoMedicos;

}
