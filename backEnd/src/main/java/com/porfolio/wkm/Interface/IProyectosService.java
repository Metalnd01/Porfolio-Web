package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Proyectos;
import java.util.List;

public interface IProyectosService {
    
    //listado de Proyectos
    public List<Proyectos> getProyectos ();
    
    //agregar un Proyecto
    public void saveProyectos(Proyectos proyectos);
    
    //eliminar un Proyectos por ID
    public void deleteProyectos(Long id);
    
    //buscar Proyectos por ID
    public Proyectos findProyectos(Long id);
    
}
