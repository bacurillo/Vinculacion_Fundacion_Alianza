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
@Table(name="etnia")
public class Etnia  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtnia;

    private String etniaNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "etnia")
    private List<FichaPersonal> fichaPersonals;
}
