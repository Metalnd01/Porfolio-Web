package com.porfolio.wkm.Entity;

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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;
    
    private String tituloExp;
    private String entreAniosExp;
    private String descripcionExp;
    private String imagenExp;

    public Experiencia() {
    }

    public Experiencia(Long idExp, String tituloExp, String entreAniosExp, String descripcionExp, String imagenExp) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.entreAniosExp = entreAniosExp;
        this.descripcionExp = descripcionExp;
        this.imagenExp = imagenExp;
    }

    

    
    
    
}
