package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Proyectos;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosService {
    
    //listado de Proyectos
    public List<Proyectos> getProyectos ();
    
    //agregar un Proyecto
    public Proyectos saveProyectos(Proyectos proyectos);
    
    //eliminar un Proyectos por ID
    public void deleteProyectos(Long idProy);
    
    //buscar Proyectos por ID
    public Proyectos findProyectos(Long idProy);
    
}
