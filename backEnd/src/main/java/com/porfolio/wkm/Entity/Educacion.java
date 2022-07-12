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
public class Educacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEdu;
    
    private String imagenEdu;
    private String tituloEdu;
    private String entreAniosEdu;
    private String descripcionEdu;

    public Educacion() {
    }

    public Educacion(Long idEdu, String imagenEdu, String tituloEdu, String entreAniosEdu, String descripcionEdu) {
        this.idEdu = idEdu;
        this.imagenEdu = imagenEdu;
        this.tituloEdu = tituloEdu;
        this.entreAniosEdu = entreAniosEdu;
        this.descripcionEdu = descripcionEdu;
    }

    

    
}
