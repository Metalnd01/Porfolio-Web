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
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 0, max = 200, message = "no cumple con la longitud requerida")
    private String url_img_proyecto;
    
    @Size(min = 0, max = 100, message = "no cumple con la longitud requerida")
    private String nombreProyecto;
    
    @Size(min = 0, max = 250, message = "no cumple con la longitud requerida")
    private String descripcion;
    
    
}

