package com.porfolio.wkm.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(nullable = false, updatable = true)
    private Long id;
    private String foto_perfil;
    private String fullname;
    private String titulo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idAcerca")
    private List<AcercaDe> acercaDeList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia> experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    private List<Graficos> graficosList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idIdioma")
    private List<Idiomas> idiomasList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProy")
    private List<Proyectos> proyectosList;

    public Persona() {
    }

    public Persona(Long id, String foto_perfil, String fullname, String titulo) {
        this.id = id;
        this.foto_perfil = foto_perfil;
        this.fullname = fullname;
        this.titulo = titulo;
        
    }
    
    
}
