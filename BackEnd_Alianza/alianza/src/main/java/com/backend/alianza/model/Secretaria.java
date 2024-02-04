package com.backend.alianza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "secretaria")
public class Secretaria {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSecretaria;

    private String actividadesSecretaria;

    private String horarioSecretaria;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;
}
