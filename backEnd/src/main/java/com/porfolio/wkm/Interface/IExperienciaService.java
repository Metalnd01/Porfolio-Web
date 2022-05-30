package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
    //listado de Experiencias laborales
    public List<Experiencia> getExperiencia ();
    
    //agregar una Experiencia
    public Experiencia saveExperiencia(Experiencia experiencia);
    
    //eliminar una Experiencia laboral por ID
    public void deleteExperiencia(Long idExp);
    
    //buscar Experiencia por ID
    public Experiencia findExperiencia(Long idExp);
    
}
