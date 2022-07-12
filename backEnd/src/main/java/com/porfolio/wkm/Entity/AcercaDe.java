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
public class AcercaDe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAcerca;
    
    private String acercaDe;

    public AcercaDe() {
    }

    public AcercaDe(Long idAcerca, String acercaDe) {
        this.idAcerca = idAcerca;
        this.acercaDe = acercaDe;
    }

    
}
