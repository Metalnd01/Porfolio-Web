package com.porfolio.wkm.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Idiomas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIdioma;
    
    private String imagenIdioma;
    private String nombreIdioma;
    private String entreAniosIdioma;
    private String descripcionIdioma;

    public Idiomas() {
    }

    public Idiomas(Long idIdioma, String imagenIdioma, String nombreIdioma, String entreAniosIdioma, String descripcionIdioma) {
        this.idIdioma = idIdioma;
        this.imagenIdioma = imagenIdioma;
        this.nombreIdioma = nombreIdioma;
        this.entreAniosIdioma = entreAniosIdioma;
        this.descripcionIdioma = descripcionIdioma;
    }
    
    
}
