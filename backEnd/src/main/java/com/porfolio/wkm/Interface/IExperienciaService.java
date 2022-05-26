package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
    //listado de Experiencias laborales
    public List<Experiencia> getExperiencia ();
    
    //agregar una Experiencia
    public void saveExperiencia(Experiencia experiencia);
    
    //eliminar una Experiencia laboral por ID
    public void deleteExperiencia(Long id);
    
    //buscar Experiencia por ID
    public Experiencia findExperiencia(Long id);
    
}
