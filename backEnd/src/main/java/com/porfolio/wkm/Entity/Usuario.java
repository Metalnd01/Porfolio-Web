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
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 4, max = 200, message = "no cumple con la longitud requerida")
    private String email;
    //completar
    @NotNull
    @Size(min = 8, max = 100, message = "no cumple con la longitud requerida")
    private String password;
    
}