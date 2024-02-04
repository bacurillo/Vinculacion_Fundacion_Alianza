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
@Table(name="rangoEdad")
public class RangoEdad  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRangoEdad;

    private int limInferior;

    private int limSuperior;

    @JsonIgnore
    @OneToMany(mappedBy = "rangoEdad")
    private List<FichaPersonal> fichaPersonals;



    @OneToMany(mappedBy = "rangoEdad", cascade = CascadeType.ALL)
    @JsonIgnore
    private List <Curso> curso;


}
