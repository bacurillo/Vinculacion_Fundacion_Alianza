package com.backend.alianza.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "fechaRegistro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.sql.Date fechaRegistro;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Curso> cursos;

}
