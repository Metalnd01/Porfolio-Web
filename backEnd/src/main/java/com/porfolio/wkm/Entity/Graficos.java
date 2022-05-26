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
public class Graficos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 25, message = "no cumple con la longitud requerida")
    private String nombre_skill;
    
    @NotNull
    @Size(min = 1, max = 100, message = "rango de 1 a 100")
    private Long porcentaje;
    
}
