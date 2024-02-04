package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="parroquia")
public class Parroquia implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idParroquia;

    private String parroquiaNombre;

    @ManyToOne
    @JoinColumn(name = "idCanton", referencedColumnName = "idCanton")
    private Canton canton;


    @JsonIgnore
    @OneToMany(mappedBy = "parroquia")
    private List<FichaPersonal> fichaPersonals;
}
