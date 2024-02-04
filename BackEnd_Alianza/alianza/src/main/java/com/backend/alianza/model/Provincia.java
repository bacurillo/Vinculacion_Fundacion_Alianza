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
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProvincia;

    private String provinciaNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "provincia")
    private List<Canton> listCantones;
}
