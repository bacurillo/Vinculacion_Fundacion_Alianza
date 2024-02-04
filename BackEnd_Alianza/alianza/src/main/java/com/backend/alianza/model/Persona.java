package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersona;

    private String apellidosPersona;

    private String nombresPersona;

    private String tipoIdentificacion;

    private String ciPasaporte;

    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Docente> docentes;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Secretaria> secretarias;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private Encargado encargado;
}
