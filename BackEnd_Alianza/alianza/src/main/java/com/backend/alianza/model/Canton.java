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
@Table(name="canton")
public class Canton  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCanton;

    private String cantonNombre;

    @ManyToOne
    @JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia")
    private Provincia provincia;

    @JsonIgnore
    @OneToMany(mappedBy = "canton")
    private List<Parroquia> listParroquias;
}
