package com.backend.alianza.model;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cursoGrado")
public class CursoGrado  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCursoGrado")
    private Long idCursoGrado;

    @Column(name = "nombreCursoGrado")
    private String nombreCursoGrado;

    @ManyToOne
    @JoinColumn(name = "idFichaEducativa")
    private FichaEducativa fichaEducativa;

}
